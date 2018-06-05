package com.padcmyanmar.sfc.data.models;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.database.AppDatabase;
import com.padcmyanmar.sfc.events.RestApiEvents;
import com.padcmyanmar.sfc.network.MMNewsDataAgent;
import com.padcmyanmar.sfc.network.MMNewsDataAgentImpl;
import com.padcmyanmar.sfc.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aung on 12/3/17.
 */

public class NewsModel extends ViewModel{


    private AppDatabase appDatabase;
    private int mmNewsPageIndex = 1;
    private MMNewsDataAgentImpl mmNewsDataAgent;

    public NewsModel() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

        mmNewsDataAgent=MMNewsDataAgentImpl.getInstance();
        mmNewsDataAgent.loadMMNews(AppConstants.ACCESS_TOKEN, 1);

    }

    public void loadAllNews(){

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
            appDatabase.newsDao().addNewsData(newsVO);
        }

    }
}
