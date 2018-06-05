package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/3/17.
 */


@Entity(tableName = "sent_to")
public class SentToVO {

    @ColumnInfo(name ="send-to-id")
    private String sendToId;

    @ColumnInfo(name ="sent-date")
    private String sentDate;

    @SerializedName("acted-user")
    private ActedUserVO sender;

    @ColumnInfo(name ="received-user")
    private ActedUserVO receiver;

    public String getSendToId() {
        return sendToId;
    }

    public void setSendToId(String sendToId) {
        this.sendToId = sendToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public ActedUserVO getSender() {
        return sender;
    }

    public void setSender(ActedUserVO sender) {
        this.sender = sender;
    }

    public ActedUserVO getReceiver() {
        return receiver;
    }

    public void setReceiver(ActedUserVO receiver) {
        this.receiver = receiver;
    }
}
