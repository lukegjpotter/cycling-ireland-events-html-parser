package com.lukegjpotter.spring.application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class StageDetail {

    @Id @GeneratedValue(strategy=GenerationType.TABLE)
    private long id;
    private Date date;
    private String venue;
    private String raceType;
    private String category;
    private String startTime;
    private String routeLinkUrl;
    private String stageName;
    private Double kilometers;

    public StageDetail() {
        setDate(new Date(0L));
        setVenue("");
        setRaceType("");
        setKilometers(0.0);
        setCategory("");
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
                    && this.getStageName().equals(other.getStageName())
                    && this.getKilometers().equals(other.getKilometers())
                    && this.getCategory().equals(other.getCategory())
                    && this.getStartTime().equals(other.getStartTime())
                    && this.getRaceType().equals(other.getRaceType())
                    && this.getVenue().equals(other.getVenue())
                    && this.getRouteLinkUrl().equals(other.getRouteLinkUrl());
        }

        return false;
    }

    @Override public int hashCode() {

        return Objects.hash(id, date, venue, raceType, category, startTime, routeLinkUrl, stageName, kilometers);
    }

    @Override public String toString() {

        return this.getStageName() + ": "
                + this.getCategory() + " - "
                + this.getKilometers() + "km";
    }

    // TODO Hacking MappingHolderToStageDetailsService to get it to build.
    public String getStageNumber() {
        return "1";
    }
}
