package com.lukegjpotter.spring.application.model;

import java.util.Date;
import java.util.List;

public class RoadRaceEvent {

    // Page 1 Details
    private String eventName, startDay, signOnTime, provience, category, promotingClub, primaryContactPerson,
            primaryContactEmail, primaryContactPhoneNumber, moreInfoUrl, locationDetails;
    private Date startDate;

    // Page 2 Details
    private String signOnLocation;
    private Date endDate;
    private List<StageDetail> stageDetails;

    public RoadRaceEvent(String eventName, String startDay, String startDate, String signOnTime, String provience,
            String category, String promotingClub, String primaryContactPerson, String primaryContactEmail,
            String primaryContactPhoneNumber, String moreInfoUrl, String locationDetails) {
        
        this.eventName = eventName;
        // TODO Implement this
    }

    public RoadRaceEvent(String signOnLocation, String endDate, List<StageDetail> stageDetails) {
        // TODO Implement this
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

    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
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
