
package com.example.android.insanyah.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DonationModel implements Serializable
{

    @SerializedName("Id")
    @Expose
    private long id;
    @SerializedName("NgoID")
    @Expose
    private long ngoID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("NameEn")
    @Expose
    private Object nameEn;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("DetailsEn")
    @Expose
    private String detailsEn;
    @SerializedName("Logo")
    @Expose
    private String logo;
    @SerializedName("Importance")
    @Expose
    private long importance;
    @SerializedName("Fromdate")
    @Expose
    private String fromdate;
    @SerializedName("Todate")
    @Expose
    private String todate;
    @SerializedName("Needs")
    @Expose
    private String needs;
    @SerializedName("NeedsEn")
    @Expose
    private String needsEn;
    @SerializedName("RecordCreationTime")
    @Expose
    private String recordCreationTime;
    @SerializedName("ProjectID")
    @Expose
    private Object projectID;
    @SerializedName("TargetAmount")
    @Expose
    private long targetAmount;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("TargetRecieved")
    @Expose
    private long targetRecieved;
    @SerializedName("NgoName")
    @Expose
    private String ngoName;
    private final static long serialVersionUID = 1790462040007803130L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DonationModel() {
    }

    /**
     * 
     * @param logo
     * @param detailsEn
     * @param nameEn
     * @param needs
     * @param ngoName
     * @param needsEn
     * @param recordCreationTime
     * @param todate
     * @param targetAmount
     * @param currency
     * @param id
     * @param projectID
     * @param details
     * @param importance
     * @param name
     * @param fromdate
     * @param ngoID
     * @param targetRecieved
     */
    public DonationModel(long id, long ngoID, String name, Object nameEn, String details, String detailsEn, String logo, long importance, String fromdate, String todate, String needs, String needsEn, String recordCreationTime, Object projectID, long targetAmount, String currency, long targetRecieved, String ngoName) {
        super();
        this.id = id;
        this.ngoID = ngoID;
        this.name = name;
        this.nameEn = nameEn;
        this.details = details;
        this.detailsEn = detailsEn;
        this.logo = logo;
        this.importance = importance;
        this.fromdate = fromdate;
        this.todate = todate;
        this.needs = needs;
        this.needsEn = needsEn;
        this.recordCreationTime = recordCreationTime;
        this.projectID = projectID;
        this.targetAmount = targetAmount;
        this.currency = currency;
        this.targetRecieved = targetRecieved;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getNameEn() {
        return nameEn;
    }

    public void setNameEn(Object nameEn) {
        this.nameEn = nameEn;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetailsEn() {
        return detailsEn;
    }

    public void setDetailsEn(String detailsEn) {
        this.detailsEn = detailsEn;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getImportance() {
        return importance;
    }

    public void setImportance(long importance) {
        this.importance = importance;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getNeeds() {
        return needs;
    }

    public void setNeeds(String needs) {
        this.needs = needs;
    }

    public String getNeedsEn() {
        return needsEn;
    }

    public void setNeedsEn(String needsEn) {
        this.needsEn = needsEn;
    }

    public String getRecordCreationTime() {
        return recordCreationTime;
    }

    public void setRecordCreationTime(String recordCreationTime) {
        this.recordCreationTime = recordCreationTime;
    }

    public Object getProjectID() {
        return projectID;
    }

    public void setProjectID(Object projectID) {
        this.projectID = projectID;
    }

    public long getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(long targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getTargetRecieved() {
        return targetRecieved;
    }

    public void setTargetRecieved(long targetRecieved) {
        this.targetRecieved = targetRecieved;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

}
