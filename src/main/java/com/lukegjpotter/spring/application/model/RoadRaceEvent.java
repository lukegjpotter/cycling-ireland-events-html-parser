package com.lukegjpotter.spring.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoadRaceEvent {

    private Date startDate, bookingsOpenDate, bookingsCloseDate;
    private String eventName, promotingClub, organiser, registrationLink, organiserPhoneNumber, organiserEmail,
            location, province;
    private List<StageDetail> stageDetails;

    /** Empty Constructor for easy Event Building. */
    public RoadRaceEvent() {
        stageDetails = new ArrayList<>();
    }
    
    public void addDescription(Description description) {
        setBookingsOpenDate(description.getBookingsOpenDate());
        setBookingsCloseDate(description.getBookingsCloseDate());
        setOrganiserPhoneNumber(description.getOrganiserPhoneNumber());
        setOrganiserEmail(description.getOrganiserEmail());
        setLocation(description.getLocation());
        setProvince(description.getProvince());
    }
    
    public void addStageDetail(StageDetail stageDetail) {
        this.getStageDetails().add(stageDetail);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getBookingsOpenDate() {
        return bookingsOpenDate;
    }

    public void setBookingsOpenDate(Date bookingsOpenDate) {
        this.bookingsOpenDate = bookingsOpenDate;
    }

    public Date getBookingsCloseDate() {
        return bookingsCloseDate;
    }

    public void setBookingsCloseDate(Date bookingsCloseDate) {
        this.bookingsCloseDate = bookingsCloseDate;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPromotingClub() {
        return promotingClub;
    }

    public void setPromotingClub(String promotingClub) {
        this.promotingClub = promotingClub;
    }

    public String getOrganiser() {
        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    public String getOrganiserPhoneNumber() {
        return organiserPhoneNumber;
    }

    public void setOrganiserPhoneNumber(String organiserPhoneNumber) {
        this.organiserPhoneNumber = organiserPhoneNumber;
    }

    public String getOrganiserEmail() {
        return organiserEmail;
    }

    public void setOrganiserEmail(String organiserEmail) {
        this.organiserEmail = organiserEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<StageDetail> getStageDetails() {
        return stageDetails;
    }

    public void setStageDetails(List<StageDetail> stageDetails) {
        this.stageDetails = stageDetails;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof RoadRaceEvent) {
            RoadRaceEvent other = (RoadRaceEvent) obj;

            return this.getStartDate().equals(other.getStartDate()) && this.getEventName().equals(other.getEventName())
                    && this.getPromotingClub().equals(other.getPromotingClub())
                    && this.getOrganiser().equals(other.getOrganiser())
                    && this.getRegistrationLink().equals(other.getRegistrationLink())
                    && this.getBookingsOpenDate().equals(other.getBookingsOpenDate())
                    && this.getBookingsCloseDate().equals(other.getBookingsCloseDate())
                    && this.getOrganiserPhoneNumber().equals(other.getOrganiserPhoneNumber())
                    && this.getOrganiserEmail().equals(other.getOrganiserEmail())
                    && this.getLocation().equals(other.getLocation()) && this.getProvince().equals(other.getProvince());
        }

        return false;
    }
    
    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getEventName()).append(" by ").append(this.getPromotingClub());
        sb.append(" in ").append(this.getLocation());
        sb.append(". Stages: ").append(this.getStageDetails().size()).append(".");
        this.getStageDetails().forEach(stagedetail -> sb.append(stagedetail.toString()));
        return sb.toString();
    }
    
}
