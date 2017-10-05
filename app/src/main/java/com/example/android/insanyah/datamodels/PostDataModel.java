
package com.example.android.insanyah.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PostDataModel implements Serializable
{

    @SerializedName("Id")
    @Expose
    private long id;
    @SerializedName("AccountImage")
    @Expose
    private String accountImage;
    @SerializedName("AccountName")
    @Expose
    private String accountName;
    @SerializedName("PostOwnerLink")
    @Expose
    private String postOwnerLink;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("AlreadyLikedPost")
    @Expose
    private boolean alreadyLikedPost;
    @SerializedName("CanDelete")
    @Expose
    private boolean canDelete;
    @SerializedName("LikesCount")
    @Expose
    private long likesCount;
    @SerializedName("CreatedTime")
    @Expose
    private String createdTime;
    @SerializedName("FullCreatedTime")
    @Expose
    private String fullCreatedTime;
    @SerializedName("CreationDate")
    @Expose
    private String creationDate;
    @SerializedName("ReportReleaseDate")
    @Expose
    private String reportReleaseDate;
    @SerializedName("UploadedFiles")
    @Expose
    private List<Object> uploadedFiles = null;
    @SerializedName("Videos")
    @Expose
    private Object videos;
    @SerializedName("Comments")
    @Expose
    private List<Object> comments = null;
    @SerializedName("Likes")
    @Expose
    private List<LikeModel> likeModels = null;
    @SerializedName("Interests")
    @Expose
    private List<InterestModel> interestModels = null;
    @SerializedName("Volunteer")
    @Expose
    private VolunteerModel volunteerModel;
    @SerializedName("Job")
    @Expose
    private Object job;
    @SerializedName("Donation")
    @Expose
    private DonationModel donationModel;
    @SerializedName("Project")
    @Expose
    private Object project;
    @SerializedName("Rating")
    @Expose
    private Object rating;
    @SerializedName("IsVolunteer")
    @Expose
    private boolean isVolunteer;
    @SerializedName("IsJob")
    @Expose
    private boolean isJob;
    @SerializedName("IsDonation")
    @Expose
    private boolean isDonation;
    @SerializedName("IsProject")
    @Expose
    private boolean isProject;
    @SerializedName("IsRating")
    @Expose
    private boolean isRating;
    @SerializedName("IsReport")
    @Expose
    private boolean isReport;
    @SerializedName("NgoId")
    @Expose
    private long ngoId;
    @SerializedName("DonationId")
    @Expose
    private long donationId;
    @SerializedName("IsMine")
    @Expose
    private boolean isMine;
    @SerializedName("EditUrl")
    @Expose
    private Object editUrl;
    @SerializedName("ChildPost")
    @Expose
    private Object childPost;
    private final static long serialVersionUID = -8501883934918653279L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PostDataModel() {
    }

    /**
     * 
     * @param fullCreatedTime
     * @param isJob
     * @param interestModels
     * @param canDelete
     * @param volunteerModel
     * @param alreadyLikedPost
     * @param id
     * @param isMine
     * @param ngoId
     * @param isReport
     * @param isProject
     * @param uploadedFiles
     * @param isRating
     * @param reportReleaseDate
     * @param isVolunteer
     * @param text
     * @param donationId
     * @param createdTime
     * @param likesCount
     * @param videos
     * @param editUrl
     * @param job
     * @param donationModel
     * @param isDonation
     * @param creationDate
     * @param project
     * @param accountName
     * @param likeModels
     * @param accountImage
     * @param postOwnerLink
     * @param rating
     * @param comments
     * @param childPost
     */
    public PostDataModel(long id, String accountImage, String accountName, String postOwnerLink, String text, boolean alreadyLikedPost, boolean canDelete, long likesCount, String createdTime, String fullCreatedTime, String creationDate, String reportReleaseDate, List<Object> uploadedFiles, Object videos, List<Object> comments, List<LikeModel> likeModels, List<InterestModel> interestModels, VolunteerModel volunteerModel, Object job, DonationModel donationModel, Object project, Object rating, boolean isVolunteer, boolean isJob, boolean isDonation, boolean isProject, boolean isRating, boolean isReport, long ngoId, long donationId, boolean isMine, Object editUrl, Object childPost) {
        super();
        this.id = id;
        this.accountImage = accountImage;
        this.accountName = accountName;
        this.postOwnerLink = postOwnerLink;
        this.text = text;
        this.alreadyLikedPost = alreadyLikedPost;
        this.canDelete = canDelete;
        this.likesCount = likesCount;
        this.createdTime = createdTime;
        this.fullCreatedTime = fullCreatedTime;
        this.creationDate = creationDate;
        this.reportReleaseDate = reportReleaseDate;
        this.uploadedFiles = uploadedFiles;
        this.videos = videos;
        this.comments = comments;
        this.likeModels = likeModels;
        this.interestModels = interestModels;
        this.volunteerModel = volunteerModel;
        this.job = job;
        this.donationModel = donationModel;
        this.project = project;
        this.rating = rating;
        this.isVolunteer = isVolunteer;
        this.isJob = isJob;
        this.isDonation = isDonation;
        this.isProject = isProject;
        this.isRating = isRating;
        this.isReport = isReport;
        this.ngoId = ngoId;
        this.donationId = donationId;
        this.isMine = isMine;
        this.editUrl = editUrl;
        this.childPost = childPost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountImage() {
        return accountImage;
    }

    public void setAccountImage(String accountImage) {
        this.accountImage = accountImage;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPostOwnerLink() {
        return postOwnerLink;
    }

    public void setPostOwnerLink(String postOwnerLink) {
        this.postOwnerLink = postOwnerLink;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAlreadyLikedPost() {
        return alreadyLikedPost;
    }

    public void setAlreadyLikedPost(boolean alreadyLikedPost) {
        this.alreadyLikedPost = alreadyLikedPost;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public long getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getFullCreatedTime() {
        return fullCreatedTime;
    }

    public void setFullCreatedTime(String fullCreatedTime) {
        this.fullCreatedTime = fullCreatedTime;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getReportReleaseDate() {
        return reportReleaseDate;
    }

    public void setReportReleaseDate(String reportReleaseDate) {
        this.reportReleaseDate = reportReleaseDate;
    }

    public List<Object> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<Object> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public Object getVideos() {
        return videos;
    }

    public void setVideos(Object videos) {
        this.videos = videos;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    public List<LikeModel> getLikeModels() {
        return likeModels;
    }

    public void setLikeModels(List<LikeModel> likeModels) {
        this.likeModels = likeModels;
    }

    public List<InterestModel> getInterestModels() {
        return interestModels;
    }

    public void setInterestModels(List<InterestModel> interestModels) {
        this.interestModels = interestModels;
    }

    public VolunteerModel getVolunteerModel() {
        return volunteerModel;
    }

    public void setVolunteerModel(VolunteerModel volunteerModel) {
        this.volunteerModel = volunteerModel;
    }

    public Object getJob() {
        return job;
    }

    public void setJob(Object job) {
        this.job = job;
    }

    public DonationModel getDonationModel() {
        return donationModel;
    }

    public void setDonationModel(DonationModel donationModel) {
        this.donationModel = donationModel;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public boolean isIsVolunteer() {
        return isVolunteer;
    }

    public void setIsVolunteer(boolean isVolunteer) {
        this.isVolunteer = isVolunteer;
    }

    public boolean isIsJob() {
        return isJob;
    }

    public void setIsJob(boolean isJob) {
        this.isJob = isJob;
    }

    public boolean isIsDonation() {
        return isDonation;
    }

    public void setIsDonation(boolean isDonation) {
        this.isDonation = isDonation;
    }

    public boolean isIsProject() {
        return isProject;
    }

    public void setIsProject(boolean isProject) {
        this.isProject = isProject;
    }

    public boolean isIsRating() {
        return isRating;
    }

    public void setIsRating(boolean isRating) {
        this.isRating = isRating;
    }

    public boolean isIsReport() {
        return isReport;
    }

    public void setIsReport(boolean isReport) {
        this.isReport = isReport;
    }

    public long getNgoId() {
        return ngoId;
    }

    public void setNgoId(long ngoId) {
        this.ngoId = ngoId;
    }

    public long getDonationId() {
        return donationId;
    }

    public void setDonationId(long donationId) {
        this.donationId = donationId;
    }

    public boolean isIsMine() {
        return isMine;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public Object getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(Object editUrl) {
        this.editUrl = editUrl;
    }

    public Object getChildPost() {
        return childPost;
    }

    public void setChildPost(Object childPost) {
        this.childPost = childPost;
    }

}
