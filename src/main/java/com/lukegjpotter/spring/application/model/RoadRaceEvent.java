package com.lukegjpotter.spring.application.model;

import java.util.Date;
import java.util.List;

import com.lukegjpotter.spring.application.util.Utils;

public class RoadRaceEvent {

    // Page 1 Details
    private String eventName, startDay, signOnTime, province, category, promotingClub, primaryContactPerson,
            primaryContactEmail, primaryContactPhoneNumber, moreInfoUrl, locationDetails;
    private Date startDate;

    // Page 2 Details
    private String signOnLocation;
    private Date endDate;
    private List<StageDetail> stageDetails;

    /** Constructor for the details on Page One. */
    public RoadRaceEvent(String eventName, String startDay, String startDate, String signOnTime, String province,
            String category, String promotingClub, String primaryContactPerson, String primaryContactEmail,
            String primaryContactPhoneNumber, String moreInfoUrl, String locationDetails) {
        
        setEventName(eventName);
        setStartDay(startDay);
        setStartDate(Utils.convertStringToDate(startDate));
        setSignOnTime(signOnTime);
        setProvince(province);
        setCategory(category);
        setPromotingClub(promotingClub);
        setPrimaryContactPerson(primaryContactPerson);
        setPrimaryContactEmail(primaryContactEmail);
        setPrimaryContactPhoneNumber(primaryContactPhoneNumber);
        setMoreInfoUrl(moreInfoUrl);
        setLocationDetails(locationDetails);
    }

    /** Constructor for the details on Page Two. */
    public RoadRaceEvent(String signOnLocation, String endDate, List<StageDetail> stageDetails) {
        setSignOnLocation(signOnLocation);
        setEndDate(Utils.convertStringToDate(endDate));
        setStageDetails(stageDetails);
    }
    
    /** Empty Constructor for easy Event Building. */
    public RoadRaceEvent() {}

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getSignOnTime() {
        return signOnTime;
    }

    public void setSignOnTime(String signOnTime) {
        this.signOnTime = signOnTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPromotingClub() {
        return promotingClub;
    }

    public void setPromotingClub(String promotingClub) {
        this.promotingClub = promotingClub;
    }

    public String getPrimaryContactPerson() {
        return primaryContactPerson;
    }

    public void setPrimaryContactPerson(String primaryContactPerson) {
        this.primaryContactPerson = primaryContactPerson;
    }

    public String getPrimaryContactEmail() {
        return primaryContactEmail;
    }

    public void setPrimaryContactEmail(String primaryContactEmail) {
        this.primaryContactEmail = primaryContactEmail;
    }

    public String getPrimaryContactPhoneNumber() {
        return primaryContactPhoneNumber;
    }

    public void setPrimaryContactPhoneNumber(String primaryContactPhoneNumber) {
        this.primaryContactPhoneNumber = primaryContactPhoneNumber;
    }

    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    public void setMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSignOnLocation() {
        return signOnLocation;
    }

    public void setSignOnLocation(String signOnLocation) {
        this.signOnLocation = signOnLocation;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<StageDetail> getStageDetails() {
        return stageDetails;
    }

    public void setStageDetails(List<StageDetail> stageDetails) {
        this.stageDetails = stageDetails;
    }

    public void addStageDetail(StageDetail stageDetail) {
        this.stageDetails.add(stageDetail);
    }
}
