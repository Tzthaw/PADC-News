package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/3/17.
 */
@Entity(tableName = "comment_action")
public class CommentActionVO {

    @ColumnInfo(name ="comment-id")
    private String commentId;

    @ColumnInfo(name ="comment")
    private String comment;

    @ColumnInfo(name ="comment-date")
    private String commentDate;

    @ColumnInfo(name ="acted-user")
    private ActedUserVO actedUser;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
