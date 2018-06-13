package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/3/17.
 */

@Entity(tableName = "publication")
public class PublicationVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="publication-auto-id")
    int publicationAutoId;

    @ColumnInfo(name ="publication-id")
    private String publicationId;

    @ColumnInfo(name ="title")
    private String title;

    @ColumnInfo(name ="logo")
    private String logo;

    public String getPublicationId() {
        return publicationId;
    }

    public int getPublicationAutoId() {
        return publicationAutoId;
    }

    public void setPublicationAutoId(int publicationAutoId) {
        this.publicationAutoId = publicationAutoId;
    }

    public void setPublicationId(String publicationId) {

        this.publicationId = publicationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
