package com.padcmyanmar.sfc.database.daos.base;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import java.util.List;

public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract long insert(T data);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract long[] insertAll(List<T> datas);

    @Update
    abstract void update(T data);

    @Delete
    abstract void delete(T data);
}
