package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.*;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to reduce the boilerplate needed to create Database Records
 * in the other actual test classes.
 * 
 * @author lukegjpotter
 */
@Component
public class RoadRaceEventToDatabaseRecordTransformServiceTestResources {

    @Autowired
    private UtilsService utils;
    
    public List<RoadRaceEvent> getTwoRaceList() {
        List<RoadRaceEvent> twoRaces = getOneDayRaceList();
        twoRaces.addAll(getStageRaceList());
        
        return twoRaces;
    }

    /**
     * Gets a List with only one One Day Race in it.
     * @return List of one One Day Race.
     */
    public List<RoadRaceEvent> getOneDayRaceList() {
        List<RoadRaceEvent> oneDayRaces = new ArrayList<>();
        oneDayRaces.add(getOneDayRace());
        
        return oneDayRaces;
    }

    /**
     * Gets a One Day Race.
     * @return {@link RoadRaceEvent} for a one day race.
     */
    public RoadRaceEvent getOneDayRace() {
        RoadRaceEvent oneDayRace = getOneDayRaceHeader();
        oneDayRace.addDescription(getOneDayRaceDescription());
        oneDayRace.setStageDetails(getOneDayRaceStageDetails());
        
        return oneDayRace;
    }
    
    /**
     * Gets the header part of a One Day Race {@link RoadRaceEvent}.
     * This does not include the {@link StageDetail} List.
     * 
     * @return {@link RoadRaceEvent} with only the headers filled in.
     */
    public RoadRaceEvent getOneDayRaceHeader() {
        RoadRaceEvent oneDayRace = new RoadRaceEvent();
        oneDayRace.setStartDate(utils.convertDDMMMYYYYToDate("03 Apr 2016"));
        oneDayRace.setEventName("Dungarvan Open Race");
        oneDayRace.setPromotingClub("Dungarvan CC");
        oneDayRace.setOrganiser("John Coleman");
        oneDayRace.setRegistrationLink("");
        
        return oneDayRace;
    }

    /**
     * Gets the {@link Description} for a One Day Race.
     * @return {@link Description} for a One Day Race.
     */
    public Description getOneDayRaceDescription() {
        Description description = new Description();
        description.setBookingsOpenDate(utils.convertDDMMMYYYYToDate("03 Apr 2016"));
        description.setBookingsCloseDate(utils.convertDDMMMYYYYToDate("03 Apr 2016"));
        description.setOrganiserPhoneNumber("+353858500404");
        description.setOrganiserEmail("john.coleman@mts.ie");
        description.setLocation("Soccer Club, Dungarvan");
        description.setProvince("Munster");
        
        return description;
    }

    /**
     * Gets the {@link StageDetail} for a One Day Race.
     * @return {@link List} containing {@link StageDetail} objects.
     */
    public List<StageDetail> getOneDayRaceStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        StageDetail stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("3 Apr 2016"));
        stageDetail.setVenue("Soccer Club");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("");
        stageDetail.setStageName("Stage 1");
        stageDetails.add(stageDetail);

        stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("3 Apr 2016"));
        stageDetail.setVenue("Soccer Club");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("A4,Women");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("");
        stageDetail.setStageName("Stage 2");
        stageDetails.add(stageDetail);

        return stageDetails;
    }
    
    /**
     * Gets a List of a Stage Race {@link RoadRaceEvent}.
     * It will contain one Stage Race.
     * 
     * @return {@link List} containing one Stage Race.
     */
    public List<RoadRaceEvent> getStageRaceList() {
        List<RoadRaceEvent> stageRaces = new ArrayList<>();
        stageRaces.add(getStageRace());
        
        return stageRaces;
    }

    /**
     * Gets a stage race.
     * @return {@link RoadRaceEvent} for  stage race.
     */
    public RoadRaceEvent getStageRace() {
        RoadRaceEvent stageRace = getStageRaceHeader();
        stageRace.addDescription(getStageRaceDescription());
        stageRace.setStageDetails(getStageRaceStageDetails());
        
        return stageRace;
    }
    
    /**
     * Gets the header part of a Stage Race {@link RoadRaceEvent}.
     * This does not include the {@link StageDetail} List.
     * 
     * @return {@link RoadRaceEvent} with only the headers filled in.
     */
    public RoadRaceEvent getStageRaceHeader() {
        RoadRaceEvent stageRace = new RoadRaceEvent();
        stageRace.setStartDate(utils.convertDDMMMYYYYToDate("30 Jul 2016"));
        stageRace.setEventName("Suir Valley 3 Day");
        stageRace.setPromotingClub("Clonmel CC");
        stageRace.setOrganiser("Declan Byrne");
        stageRace.setRegistrationLink("");
        
        return stageRace;
    }

    /**
     * Gets the {@link Description} for a Stage Race.
     * @return {@link Description} for a Stage Race.
     */
    public Description getStageRaceDescription() {
        Description description = new Description();
        description.setBookingsOpenDate(utils.convertDDMMMYYYYToDate("30 Jul 2016"));
        description.setBookingsCloseDate(utils.convertDDMMMYYYYToDate("01 Aug 2016"));
        description.setOrganiserPhoneNumber("+353879369628");
        description.setOrganiserEmail("declanbyrne2006@gmail.com");
        description.setLocation("HEARNS HOTEL, CLONMEL");
        //description.setProvince("Munster");
        
        return description;
    }

    /**
     * Gets the {@link StageDetail} for a Stage Race.
     * @return {@link List} of {@link StageDetail} for stage race.
     */
    public List<StageDetail> getStageRaceStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        StageDetail stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("30 Jul 2016"));
        stageDetail.setVenue("HEARNS HOTEL");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("APlus,A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("");
        stageDetail.setStageName("Stage 1");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("31 Jul 2016"));
        stageDetail.setVenue("HEARNS HOTEL");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("APlus,A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("");
        stageDetail.setStageName("Stage 2");
        stageDetails.add(stageDetail);

        return stageDetails;
    }
    
    public List<RoadRaceEventDatabaseRecord> getOneDayRaceDatabaseRecordList() {
        List<RoadRaceEventDatabaseRecord> oneDayRaceRecords = new ArrayList<>();
        RoadRaceEventDatabaseRecord oneDayRaceRecord = new RoadRaceEventDatabaseRecord();
        oneDayRaceRecord.setStartDate(utils.convertDDMMMYYYYToDate("03 Apr 2016"));
        oneDayRaceRecord.setEventName("Dungarvan Open Race");
        oneDayRaceRecord.setPromotingClub("Dungarvan CC");
        oneDayRaceRecord.setOrganiser("John Coleman");
        oneDayRaceRecord.setRegistrationLink("");
        oneDayRaceRecord.addDescription(getOneDayRaceDescription());
        oneDayRaceRecord.setStageDetails(getOneDayRaceStageDetails());
        oneDayRaceRecord.addRaceTypes(getOneDayRaceTypesHolder());
        oneDayRaceRecords.add(oneDayRaceRecord);
        
        return oneDayRaceRecords;
    }
    
    public RoadRaceEventDatabaseRecord getStageRaceDatabaseRecord() {
        RoadRaceEventDatabaseRecord stageRaceRecord = new RoadRaceEventDatabaseRecord();
        stageRaceRecord.setStartDate(utils.convertDDMMMYYYYToDate("30 Jul 2016"));
        stageRaceRecord.setEventName("Suir Valley 3 Day");
        stageRaceRecord.setPromotingClub("Clonmel CC");
        stageRaceRecord.setOrganiser("Declan Byrne");
        stageRaceRecord.setRegistrationLink("");
        stageRaceRecord.addDescription(getStageRaceDescription());
        stageRaceRecord.setStageDetails(getStageRaceStageDetails());
        stageRaceRecord.addRaceTypes(getStageRaceTypesHolder());
        
        return stageRaceRecord;
    }

    public List<RoadRaceEventDatabaseRecord> getTwoRaceDatabaseRecordList() {
        List<RoadRaceEventDatabaseRecord> raceRecords = getOneDayRaceDatabaseRecordList();
        raceRecords.add(getStageRaceDatabaseRecord());
        
        return raceRecords;
    }
    
    public RaceTypesHolder getOneDayRaceTypesHolder() {
        RaceTypesHolder raceTypesHolder = new RaceTypesHolder();
        raceTypesHolder.setA1(true);
        raceTypesHolder.setA2(true);
        raceTypesHolder.setA3(true);
        raceTypesHolder.setA4(true);
        raceTypesHolder.setWoman(true);
        raceTypesHolder.setYouth(true);
        
        return raceTypesHolder;
    }
    
    public RaceTypesHolder getStageRaceTypesHolder() {
        RaceTypesHolder raceTypesHolder = new RaceTypesHolder();
        raceTypesHolder.setAPlus(true);
        raceTypesHolder.setA1(true);
        raceTypesHolder.setA2(true);
        raceTypesHolder.setA3(true);
        
        return raceTypesHolder;
    }
    
}
