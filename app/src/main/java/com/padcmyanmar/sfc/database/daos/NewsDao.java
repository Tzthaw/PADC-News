package com.padcmyanmar.sfc.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.NewsVO;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("DELETE FROM news")
    void deleteNewsData();

    @Query("SELECT * FROM news ")
    LiveData<List<NewsVO>> getAllNews();


    @Insert
    long addNewsData(NewsVO newsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] addAllNewsData(NewsVO... newsVO);
}
