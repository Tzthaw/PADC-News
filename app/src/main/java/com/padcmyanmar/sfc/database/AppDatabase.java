package com.padcmyanmar.sfc.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.CommentActionVO;
import com.padcmyanmar.sfc.data.vo.FavoriteActionVO;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.data.vo.PublicationVO;
import com.padcmyanmar.sfc.data.vo.SentToVO;
import com.padcmyanmar.sfc.database.daos.NewsDao;
import com.padcmyanmar.sfc.utils.AppConstants;

@Database(entities = {NewsVO.class,PublicationVO.class},version = 2 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase appDatabase;
    public abstract NewsDao newsDao();


    public static AppDatabase getInMemoryDatabase(Context context){
        if(appDatabase==null){
            appDatabase=Room.databaseBuilder(context,AppDatabase.class,AppConstants.DB_NAME)
                    .allowMainThreadQueries()
//                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }

    public static void clearInMemoryDatabase(){
        appDatabase=null;
    }
}
