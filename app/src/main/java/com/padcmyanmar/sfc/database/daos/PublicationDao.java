package com.padcmyanmar.sfc.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.PublicationVO;
import com.padcmyanmar.sfc.database.daos.base.BaseDao;

import java.util.List;

@Dao
public interface PublicationDao extends BaseDao<PublicationVO>{


    @Query("SELECT * FROM  publication")
    LiveData<List<PublicationVO>> loadAllPublicationData();


}
