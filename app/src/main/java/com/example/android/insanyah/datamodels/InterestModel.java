
package com.example.android.insanyah.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InterestModel implements Serializable
{

    @SerializedName("Id")
    @Expose
    private long id;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Subtitle")
    @Expose
    private String subtitle;
    @SerializedName("EnglishName")
    @Expose
    private String englishName;
    @SerializedName("EnglishDescription")
    @Expose
    private Object englishDescription;
    @SerializedName("ArabicDescription")
    @Expose
    private Object arabicDescription;
    @SerializedName("ArabicName")
    @Expose
    private Object arabicName;
    @SerializedName("IsDataExist")
    @Expose
    private boolean isDataExist;
    @SerializedName("LogoPath")
    @Expose
    private Object logoPath;
    @SerializedName("Category")
    @Expose
    private Object category;
    private final static long serialVersionUID = -7030806893984049988L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InterestModel() {
    }

    /**
     * 
     * @param englishName
     * @param id
     * @param category
     * @param title
     * @param arabicName
     * @param name
     * @param subtitle
     * @param englishDescription
     * @param arabicDescription
     * @param logoPath
     * @param isDataExist
     */
    public InterestModel(long id, String title, String name, String subtitle, String englishName, Object englishDescription, Object arabicDescription, Object arabicName, boolean isDataExist, Object logoPath, Object category) {
        super();
        this.id = id;
        this.title = title;
        this.name = name;
        this.subtitle = subtitle;
        this.englishName = englishName;
        this.englishDescription = englishDescription;
        this.arabicDescription = arabicDescription;
        this.arabicName = arabicName;
        this.isDataExist = isDataExist;
        this.logoPath = logoPath;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Object getEnglishDescription() {
        return englishDescription;
    }

    public void setEnglishDescription(Object englishDescription) {
        this.englishDescription = englishDescription;
    }

    public Object getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(Object arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public Object getArabicName() {
        return arabicName;
    }

    public void setArabicName(Object arabicName) {
        this.arabicName = arabicName;
    }

    public boolean isIsDataExist() {
        return isDataExist;
    }

    public void setIsDataExist(boolean isDataExist) {
        this.isDataExist = isDataExist;
    }

    public Object getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(Object logoPath) {
        this.logoPath = logoPath;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory(Object category) {
        this.category = category;
    }

}
