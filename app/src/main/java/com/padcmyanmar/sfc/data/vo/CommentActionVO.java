package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.sfc.persistence.typeconverters.ActedUserTypeConverter;
import com.padcmyanmar.sfc.persistence.typeconverters.CommentTypeConverter;

/**
 * Created by aung on 12/3/17.
 */

@Entity(tableName = "comments", foreignKeys = {
        @ForeignKey(entity = ActedUserVO.class, parentColumns = "userId", childColumns = "acted_user_id", deferred = true)
})

public class CommentActionVO {

    @PrimaryKey
    @NonNull
    @SerializedName("comment-id")
    private String commentId;

    @SerializedName("comment")
    private String comment;

    @SerializedName("comment-date")
    private String commentDate;

    @Ignore
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    @ColumnInfo(name = "acted_user_id")
    private String actedUserId;

    public String getActedUserId() {
        if (actedUser != null)
            return actedUser.getUserId();
        return null;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }

    public void setActedUserId(String actedUserId) {
        this.actedUserId = actedUserId;
    }
}
