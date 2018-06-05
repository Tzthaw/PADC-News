package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/3/17.
 */

@Entity(tableName = "favourite_action")
public class FavoriteActionVO {

    @ColumnInfo(name ="favorite-id")
    private String favoriteId;

    @ColumnInfo(name ="favorite-date")
    private String favoriteDate;

    @ColumnInfo(name ="acted-user")
    private ActedUserVO actedUser;

    public String getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public void setFavoriteDate(String favoriteDate) {
        this.favoriteDate = favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }
}
