
package com.example.android.insanyah.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class VolunteerModel implements Serializable
{

    @SerializedName("Id")
    @Expose
    private long id;
    @SerializedName("NgoID")
    @Expose
    private long ngoID;
    @SerializedName("CsrID")
    @Expose
    private Object csrID;
    @SerializedName("ProjectID")
    @Expose
    private long projectID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("NameEn")
    @Expose
    private Object nameEn;
    @SerializedName("DetailsEn")
    @Expose
    private Object detailsEn;
    @SerializedName("when")
    @Expose
    private String when;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("Skills")
    @Expose
    private String skills;
    @SerializedName("Volunteers")
    @Expose
    private long volunteers;
    @SerializedName("RewardedHours")
    @Expose
    private long rewardedHours;
    @SerializedName("IsPrivate")
    @Expose
    private boolean isPrivate;
    @SerializedName("IsClosed")
    @Expose
    private boolean isClosed;
    @SerializedName("RecordCreationTime")
    @Expose
    private String recordCreationTime;
    @SerializedName("RemainingDay")
    @Expose
    private long remainingDay;
    @SerializedName("RemainingHour")
    @Expose
    private long remainingHour;
    @SerializedName("RemainingMinute")
    @Expose
    private long remainingMinute;
    @SerializedName("StoredSkills")
    @Expose
    private List<String> storedSkills = null;
    @SerializedName("By")
    @Expose
    private String by;
    @SerializedName("IsMember")
    @Expose
    private boolean isMember;
    @SerializedName("ChoosenInterests")
    @Expose
    private Object choosenInterests;
    @SerializedName("Logo")
    @Expose
    private String logo;
    @SerializedName("NgoName")
    @Expose
    private String ngoName;
    private final static long serialVersionUID = -4712470214987095129L;

    /**
     * No args constructor for use in serialization
     *
     */
    public VolunteerModel() {
    }

    /**
     *
     * @param skills
     * @param csrID
     * @param detailsEn
     * @param recordCreationTime
     * @param by
     * @param remainingMinute
     * @param id
     * @param projectID
     * @param details
     * @param isPrivate
     * @param choosenInterests
     * @param when
     * @param name
     * @param isClosed
     * @param rewardedHours
     * @param logo
     * @param nameEn
     * @param ngoName
     * @param volunteers
     * @param remainingDay
     * @param address
     * @param storedSkills
     * @param ngoID
     * @param isMember
     * @param remainingHour
     */
    public VolunteerModel(long id, long ngoID, Object csrID, long projectID, String name, String details, Object nameEn, Object detailsEn, String when, String address, String skills, long volunteers, long rewardedHours, boolean isPrivate, boolean isClosed, String recordCreationTime, long remainingDay, long remainingHour, long remainingMinute, List<String> storedSkills, String by, boolean isMember, Object choosenInterests, String logo, String ngoName) {
        super();
        this.id = id;
        this.ngoID = ngoID;
        this.csrID = csrID;
        this.projectID = projectID;
        this.name = name;
        this.details = details;
        this.nameEn = nameEn;
        this.detailsEn = detailsEn;
        this.when = when;
        this.address = address;
        this.skills = skills;
        this.volunteers = volunteers;
        this.rewardedHours = rewardedHours;
        this.isPrivate = isPrivate;
        this.isClosed = isClosed;
        this.recordCreationTime = recordCreationTime;
        this.remainingDay = remainingDay;
        this.remainingHour = remainingHour;
        this.remainingMinute = remainingMinute;
        this.storedSkills = storedSkills;
        this.by = by;
        this.isMember = isMember;
        this.choosenInterests = choosenInterests;
        this.logo = logo;
        this.ngoName = ngoName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNgoID() {
        return ngoID;
    }

    public void setNgoID(long ngoID) {
        this.ngoID = ngoID;
    }

    public Object getCsrID() {
        return csrID;
    }

    public void setCsrID(Object csrID) {
        this.csrID = csrID;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Object getNameEn() {
        return nameEn;
    }

    public void setNameEn(Object nameEn) {
        this.nameEn = nameEn;
    }

    public Object getDetailsEn() {
        return detailsEn;
    }

    public void setDetailsEn(Object detailsEn) {
        this.detailsEn = detailsEn;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public long getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(long volunteers) {
        this.volunteers = volunteers;
    }

    public long getRewardedHours() {
        return rewardedHours;
    }

    public void setRewardedHours(long rewardedHours) {
        this.rewardedHours = rewardedHours;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getRecordCreationTime() {
        return recordCreationTime;
    }

    public void setRecordCreationTime(String recordCreationTime) {
        this.recordCreationTime = recordCreationTime;
    }

    public long getRemainingDay() {
        return remainingDay;
    }

    public void setRemainingDay(long remainingDay) {
        this.remainingDay = remainingDay;
    }

    public long getRemainingHour() {
        return remainingHour;
    }

    public void setRemainingHour(long remainingHour) {
        this.remainingHour = remainingHour;
    }

    public long getRemainingMinute() {
        return remainingMinute;
    }

    public void setRemainingMinute(long remainingMinute) {
        this.remainingMinute = remainingMinute;
    }

    public List<String> getStoredSkills() {
        return storedSkills;
    }

    public void setStoredSkills(List<String> storedSkills) {
        this.storedSkills = storedSkills;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public boolean isIsMember() {
        return isMember;
    }

    public void setIsMember(boolean isMember) {
        this.isMember = isMember;
    }

    public Object getChoosenInterests() {
        return choosenInterests;
    }

    public void setChoosenInterests(Object choosenInterests) {
        this.choosenInterests = choosenInterests;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

}