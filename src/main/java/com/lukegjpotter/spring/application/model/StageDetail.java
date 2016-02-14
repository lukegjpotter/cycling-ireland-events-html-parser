package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class StageDetail {

    private Date date;
    private int raceNumber;
    private String stageNumber, raceTypes, category, signOnTime, startTime, routeLinkUrl;
    private double kilometers, miles;

    public StageDetail(String date, int raceNumber, String stageNumber, String raceType, int kilometers, double miles,
            String category, String signOnTime, String startTime, String routeLinkUrl) {
        // TODO Auto-generated constructor stub
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(String stageNumber) {
        this.stageNumber = stageNumber;
    }

    public String getRaceTypes() {
        return raceTypes;
    }

    public void setRaceTypes(String raceTypes) {
        this.raceTypes = raceTypes;
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
}
