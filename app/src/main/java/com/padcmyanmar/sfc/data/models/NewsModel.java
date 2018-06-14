package com.padcmyanmar.sfc.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.database.AppDatabase;
import com.padcmyanmar.sfc.events.RestApiEvents;
import com.padcmyanmar.sfc.network.MMNewsAPI;
import com.padcmyanmar.sfc.network.reponses.GetNewsResponse;
import com.padcmyanmar.sfc.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aung on 12/3/17.
 */

public class NewsModel extends ViewModel{


    private AppDatabase appDatabase;
    private int mmNewsPageIndex = 1;

    private MMNewsAPI theApi;

    public NewsModel() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

            theApi = retrofit.create(MMNewsAPI.class);


    }

    public void loadAllNews(final PublishSubject<GetNewsResponse> mNewsSubject){
        Observable<GetNewsResponse> newsApi=theApi.loadMMNews(1,AppConstants.ACCESS_TOKEN);
        newsApi.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetNewsResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(GetNewsResponse value) {
                            mNewsSubject.onNext(value);
                            mNewsSubject.publish();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void initDatabase(Context context) {
        appDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    public LiveData<List<NewsVO>> getAllNewsData(){
        return appDatabase.newsDao().getAllNews();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        AppDatabase.clearInMemoryDatabase();
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsDataLoaded(RestApiEvents.NewsDataLoadedEvent event) {
        appDatabase.newsDao().deleteNewsData();

        for(NewsVO newsVO:event.getLoadNews()){
            long ids=appDatabase.publicationDao().insert(newsVO.getPublication());
            Log.i("Id",ids+"");
              newsVO.setPublication_id(newsVO.getPublication().getPublicationId());
              appDatabase.newsDao().addNewsData(newsVO);


        }

    }
}
