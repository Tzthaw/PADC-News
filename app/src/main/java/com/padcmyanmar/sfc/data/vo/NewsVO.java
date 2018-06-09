package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;


import java.util.ArrayList;
import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by aung on 12/2/17.
 */

@Entity(tableName = "news",foreignKeys = @ForeignKey(entity = PublicationVO.class,
                        parentColumns = "publication-id",
                        childColumns = "publication_news_id",
                        onDelete = CASCADE))
public class NewsVO {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "news-id")
    private  String newsId;

    @ColumnInfo(name ="brief")
    private String brief;

    @ColumnInfo(name ="details")
    private String details;

    @Ignore
    @ColumnInfo(name ="images")
    private String[] images;

    @ColumnInfo(name ="posted-date")
    private String postedDate;

    @ColumnInfo(name = "publication_news_id")
    private String publication_id;

    @Ignore
    @ColumnInfo(name ="favorites")
    private List<FavoriteActionVO> favoriteActions;

    @Ignore
    @ColumnInfo(name ="comments")
    private List<CommentActionVO> commentActions;

    @Ignore
    @ColumnInfo(name ="sent-tos")
    private List<SentToVO> sentToActions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }


    public List<FavoriteActionVO> getFavoriteActions() {
        return favoriteActions;
    }

    public void setFavoriteActions(List<FavoriteActionVO> favoriteActions) {
        this.favoriteActions = favoriteActions;
    }

    public List<CommentActionVO> getCommentActions() {
        return commentActions;
    }

    public void setCommentActions(List<CommentActionVO> commentActions) {
        this.commentActions = commentActions;
    }

    public List<SentToVO> getSentToActions() {
        return sentToActions;
    }

    public void setSentToActions(List<SentToVO> sentToActions) {
        this.sentToActions = sentToActions;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }
}
