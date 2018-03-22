package com.lukegjpotter.spring.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StageDetail {

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;
    private Date date;
    private Integer raceNumber;
    private String stageNumber, venue, raceType, category, signOnTime, startTime, routeLinkUrl, stageName;
    private Double kilometers, miles;

    public StageDetail(Date date, String venue, Integer raceNumber, String stageNumber, String raceType,
                       Double kilometers, Double miles, String category, String signOnTime, String startTime,
                       String routeLinkUrl, String stageName) {

        setDate(date);
        setVenue(venue);
        setRaceNumber(raceNumber);
        setStageNumber(stageNumber);
        setRaceType(raceType);
        setKilometers(kilometers);
        setMiles(miles);
        setCategory(category);
        setSignOnTime(signOnTime);
        setStartTime(startTime);
        setRouteLinkUrl(routeLinkUrl);
        setStageName(stageName);
    }

    public StageDetail() {
        setDate(new Date(0L));
        setVenue("");
        setRaceNumber(0);
        setStageNumber("0");
        setRaceType("");
        setKilometers(0.0);
        setMiles(0.0);
        setCategory("");
        setSignOnTime("");
        setStartTime("");
        setRouteLinkUrl("");
        setStageName("");
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer raceNumber) {
        this.raceNumber = raceNumber;
    }

    public String getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(String stageNumber) {
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

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public Double getMiles() {
        return miles;
    }

    public void setMiles(Double miles) {
        this.miles = miles;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    @Override public boolean equals(Object obj) {

        if (obj instanceof StageDetail) {
            StageDetail other = (StageDetail) obj;

            return this.getDate().equals(other.getDate())
                    && this.getVenue().equals(other.getVenue())
                    && this.getRaceNumber().equals(other.getRaceNumber())
                    && this.getStageNumber().equals(other.getStageNumber())
                    && this.getRaceType().equals(other.getRaceType())
                    && this.getCategory().equals(other.getCategory())
                    && this.getSignOnTime().equals(other.getSignOnTime())
                    && this.getStartTime().equals(other.getStartTime())
                    && this.getRouteLinkUrl().equals(other.getRouteLinkUrl())
                    && this.getKilometers().equals(other.getKilometers())
                    && this.getMiles().equals(other.getMiles())
                    && this.stageName.equals(other.getStageName());
        }

        return false;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tRace ").append(this.getRaceNumber()).append(": ");
        sb.append("Stage ").append(this.getStageNumber()).append(": ");
        sb.append(this.getCategory()).append(" - ");
        sb.append(this.getKilometers()).append("km");
        return sb.toString();
    }
}
