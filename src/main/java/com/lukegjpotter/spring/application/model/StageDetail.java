package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class StageDetail {

    private Date date;
    private int raceNumber, stageNumber;
    private String location, raceType, category, signOnTime, startTime, routeLinkUrl;
    private double kilometers, miles;

    public StageDetail(Date date, int raceNumber, int stageNumber, String raceType, int kilometers, double miles,
            String category, String signOnTime, String startTime, String routeLinkUrl) {
        
        setDate(date);
        setLocation("");
        setRaceNumber(raceNumber);
        setStageNumber(stageNumber);
        setRaceType(raceType);
        setKilometers(kilometers);
        setMiles(miles);
        setCategory(category);
        setSignOnTime(signOnTime);
        setRouteLinkUrl(routeLinkUrl);
    }

    public StageDetail(Date date, String location, int raceNumber, int stageNumber, String raceType, double kilometers, double miles,
            String category, String signOnTime, String startTime, String routeLinkUrl) {
        
        setDate(date);
        setLocation(location);
        setRaceNumber(raceNumber);
        setStageNumber(stageNumber);
        setRaceType(raceType);
        setKilometers(kilometers);
        setMiles(miles);
        setCategory(category);
        setSignOnTime(signOnTime);
        setStartTime(startTime);
        setRouteLinkUrl(routeLinkUrl);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    public String getRaceType() {
        return raceType;
    }

    public void setRaceType(String raceType) {
        this.raceType = raceType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSignOnTime() {
        return signOnTime;
    }

    public void setSignOnTime(String signOnTime) {
        this.signOnTime = signOnTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRouteLinkUrl() {
        return routeLinkUrl;
    }

    public void setRouteLinkUrl(String routeLinkUrl) {
        this.routeLinkUrl = routeLinkUrl;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj instanceof StageDetail) {
            StageDetail other = (StageDetail) obj;
            
            return this.getDate().equals(other.getDate())
                    && this.getLocation().equals(other.getLocation())
                    && this.getRaceNumber() == other.getRaceNumber()
                    && this.getStageNumber() == other.getStageNumber()
                    && this.getRaceType().equals(other.getRaceType())
                    && this.getCategory().equals(other.getCategory())
                    && this.getSignOnTime().equals(other.getSignOnTime())
                    && this.getStartTime().equals(other.getStartTime())
                    && this.getRouteLinkUrl().equals(other.getRouteLinkUrl())
                    && this.getKilometers() == other.getKilometers()
                    && this.getMiles() == other.getMiles();
        }
        
        return false;
    }
}
