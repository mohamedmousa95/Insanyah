
package com.example.android.insanyah.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LikeModel implements Serializable
{

    @SerializedName("Id")
    @Expose
    private long id;
    @SerializedName("PostID")
    @Expose
    private long postID;
    @SerializedName("AccountID")
    @Expose
    private String accountID;
    @SerializedName("RecordCreationTime")
    @Expose
    private String recordCreationTime;
    @SerializedName("LikeImage")
    @Expose
    private String likeImage;
    @SerializedName("LikeName")
    @Expose
    private String likeName;
    @SerializedName("LikeLink")
    @Expose
    private String likeLink;
    private final static long serialVersionUID = 7222957800176836496L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LikeModel() {
    }

    /**
     * 
     * @param id
     * @param accountID
     * @param likeLink
     * @param likeName
     * @param recordCreationTime
     * @param postID
     * @param likeImage
     */
    public LikeModel(long id, long postID, String accountID, String recordCreationTime, String likeImage, String likeName, String likeLink) {
        super();
        this.id = id;
        this.postID = postID;
        this.accountID = accountID;
        this.recordCreationTime = recordCreationTime;
        this.likeImage = likeImage;
        this.likeName = likeName;
        this.likeLink = likeLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getRecordCreationTime() {
        return recordCreationTime;
    }

    public void setRecordCreationTime(String recordCreationTime) {
        this.recordCreationTime = recordCreationTime;
    }

    public String getLikeImage() {
        return likeImage;
    }

    public void setLikeImage(String likeImage) {
        this.likeImage = likeImage;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public String getLikeLink() {
        return likeLink;
    }

    public void setLikeLink(String likeLink) {
        this.likeLink = likeLink;
    }

}
