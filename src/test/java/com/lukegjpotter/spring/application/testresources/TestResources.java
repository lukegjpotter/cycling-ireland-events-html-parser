package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.Description;
import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.util.UtilsService;

/**
 * This class is to reduce the boilerplate needed to create Road Race Events in the other actual test classes.
 * @author lukegjpotter
 */
@Component
public class TestResources {
    
    @Autowired UtilsService utils;

    public String getOneDayRaceFileName() {
        return "./src/test/resources/DungarvanOpenRace.html";
    }
    
    public String getOneDayRaceHeaderFileName() {
        return "./src/test/resources/DungarvanOpenRaceHeader.html";
    }
    
    public String getOneDayRaceDescriptionFileName() {
        return "./src/test/resources/DungarvanOpenRaceDescription.html";
    }
    
    public String getOneDayRaceStageDetailFileName() {
        return "./src/test/resources/DungarvanOpenRaceStageDetail.html";
    }
    
    public String getStageRaceFileName() {
        return "./src/test/resources/SuirValley3Day.html";
    }
    
    public String getStageRaceHeaderFileName() {
        return "./src/test/resources/SuirValley3DayHeader.html";
    }
    
    public String getStageRaceDescriptionFileName() {
        return "./src/test/resources/SuirValley3DayDescription.html";
    }
    
    public String getStageRaceStageDetailFileName() {
        return "./src/test/resources/SuirValley3DayStageDetail.html";
    }
    
    public String getTwoRacesFileName() {
        return "./src/test/resources/TwoRaces.html";
    }
    
    public String getEmptyHeaderFileName() {
        return "./src/test/resources/EmptyHeader.html";
    }
    
    public String getEmptyDescriptionFileName() {
        return "./src/test/resources/EmptyDescription.html";
    }
    
    public String getEmptyStageDetailFileName() {
        return "./src/test/resources/EmptyStageDetail.html";
    }
    
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
     * Gets the header part of a One Day Race {@link RoadRaceEvent}. This does not include the {@link StageDetail} List.
     * @return {@link RoadRaceEvent} with only the headers filled in.
     */
    public RoadRaceEvent getOneDayRaceHeader() {
        RoadRaceEvent oneDayRace = new RoadRaceEvent();
        oneDayRace.setStartDate(utils.convertDDMMMYYToDate("03-Apr-16"));
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
        description.setBookingsOpenDate(utils.convertDDMMYYYYToDate("03/04/2016"));
        description.setBookingsCloseDate(utils.convertDDMMYYYYToDate("03/04/2016"));
        description.setOrganiserPhoneNumber("+353858500404");
        description.setOrganiserEmail("john.coleman@mts.ie");
        description.setLocation("Soccer Club, Dungarvan");
        //description.setProvince("Munster");
        
        return description;
    }

    /**
     * Gets the {@link StageDetail} for a One Day Race.
     * @return {@link List} containing {@link StageDetail} objects.
     */
    public List<StageDetail> getOneDayRaceStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "A1", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 2, 1, "A2", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 3, 1, "A3", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 4, 1, "A4", 70.0, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 6, 1, "U14", 18.0, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 8, 1, "Women", 70.0, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
        
        return stageDetails;
    }
    
    /**
     * Gets a List of a Stage Race {@link RoadRaceEvent}. It will contain one Stage Race.
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
     * Gets the header part of a Stage Race {@link RoadRaceEvent}. This does not include the {@link StageDetail} List.
     * @return {@link RoadRaceEvent} with only the headers filled in.
     */
    public RoadRaceEvent getStageRaceHeader() {
        RoadRaceEvent stageRace = new RoadRaceEvent();
        stageRace.setStartDate(utils.convertDDMMMYYToDate("30-Jul-16"));
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
        description.setBookingsOpenDate(utils.convertDDMMYYYYToDate("30/07/2016"));
        description.setBookingsCloseDate(utils.convertDDMMYYYYToDate("01/08/2016"));
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
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("30/07/2016"), "HEARNS HOTEL", 1, 1, "APlus,A1,A2,A3", 120.0, 74.6, "Road", "9:30", "13:00", "http://www.suirvalley3day.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), "HEARNS HOTEL", 1, 2, "APlus,A1,A2,A3", 92.0, 57.2, "Road", "9:30", "11:00", "http://www.suirvalley3day.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), "HEARNS HOTEL", 1, 3, "APlus,A1,A2,A3", 35.0, 21.7, "Criterium", "18:00", "19:00", "http://www.suirvalley3day.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("01/08/2016"), "HEARNS HOTEL", 1, 4, "APlus,A1,A2,A3", 122.0, 75.8, "Road", "9:30", "11:00", "http://www.suirvalley3day.com"));
        
        return stageDetails;
    }

    public List<RoadRaceEventDatabaseRecord> getOneDayRaceDatabaseRecordList() {
        List<RoadRaceEventDatabaseRecord> oneDayRaceRecords = new ArrayList<>();
        RoadRaceEventDatabaseRecord oneDayRaceRecord = new RoadRaceEventDatabaseRecord();
        oneDayRaceRecord.setStartDate(utils.convertDDMMMYYToDate("03-Apr-16"));
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
        stageRaceRecord.setStartDate(utils.convertDDMMMYYToDate("30-Jul-16"));
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

    public RoadRaceEventDatabaseRecord getFirstRaceFromHtmlFile() {
        RoadRaceEventDatabaseRecord raceRecord = new RoadRaceEventDatabaseRecord();
        
        raceRecord.setStartDate(utils.convertDDMMMYYToDate("02-Apr-16"));
        raceRecord.setEventName("Invacare Paracycling TT round 2");
        raceRecord.setPromotingClub("Shannonside Cycling Club");
        raceRecord.setOrganiser("Stephen Digby");
        raceRecord.setRegistrationLink("");
        
        raceRecord.setBookingsOpenDate(utils.convertDDMMYYYYToDate("02/04/2016"));
        raceRecord.setBookingsCloseDate(utils.convertDDMMYYYYToDate("01/01/1900"));
        raceRecord.setOrganiserPhoneNumber("+353879764249");
        raceRecord.setOrganiserEmail("stdigby@hotmail.com");
        raceRecord.setLocation("Buccaneers RFC, Athlone");
        //raceRecord.setProvince("Munster");
        
        List<StageDetail> stageDetails = new ArrayList<>();
        //stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("30/07/2016"), "HEARNS HOTEL", 1, 1, "APlus,A1,A2,A3", 120, 74.6, "Road", "9:30", "13:00", "http://www.suirvalley3day.com"));
        raceRecord.setStageDetails(stageDetails);
        
        return raceRecord;
    }

    public List<StageDetail> getStageDetailsAllTypes() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "APlus", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "A1", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 2, 1, "A2", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 3, 1, "A3", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 4, 1, "A4", 70.0, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "Vets", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "Junior", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 6, 1, "U14", 18.0, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 8, 1, "Women", 70.0, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
        
        return stageDetails;
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
    
    public RaceTypesHolder getRaceTypesAllEnabled() {
        RaceTypesHolder raceTypesHolder = new RaceTypesHolder();
        raceTypesHolder.setAPlus(true);
        raceTypesHolder.setA1(true);
        raceTypesHolder.setA2(true);
        raceTypesHolder.setA3(true);
        raceTypesHolder.setA4(true);
        raceTypesHolder.setVets(true);
        raceTypesHolder.setWoman(true);
        raceTypesHolder.setJunior(true);
        raceTypesHolder.setYouth(true);
        
        return raceTypesHolder;
    }

    public String getOneDayRaceStagesCsvFileName() {
        return "./src/test/resources/DungarvanOpenRaceStages.csv";
    }

    public StageRouteMappingHolder getOneDayRaceStageRouteMappingHolder() {
        String eventName = "Dungarvan Open Race";
        Date date = utils.convertDDMMYYYYToDate("03/04/2016");
        List<String> routes = Arrays.asList("http://www.strava.com/routes/123456");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getOneDayRaceStagesCsvFileNameNoStages() {
        return "./src/test/resources/DungarvanOpenRaceStagesNoStages.csv";
    }

    public StageRouteMappingHolder getOneDayRaceStageRouteMappingHolderNoStages() {
        String eventName = "Dungarvan Open Race";
        Date date = utils.convertDDMMYYYYToDate("03/04/2016");
        List<String> routes = Arrays.asList("");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileName() {
        return "./src/test/resources/SuirValley3DayStages.csv";
    }

    public StageRouteMappingHolder getStageRaceStageRouteMappingHolder() {
        String eventName = "Suir Valley 3 Day";
        Date date = utils.convertDDMMYYYYToDate("30/07/2016");
        List<String> routes = Arrays.asList("http://www.strava.com/routes/111", "http://www.strava.com/routes/222", "http://www.strava.com/routes/333", "http://www.strava.com/routes/444");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileNameNoStages() {
        return "./src/test/resources/SuirValley3DayStagesNoStages.csv";
    }

    public StageRouteMappingHolder getStageRaceStageRouteMappingHolderNoStages() {
        String eventName = "Suir Valley 3 Day";
        Date date = utils.convertDDMMYYYYToDate("30/07/2016");
        List<String> routes = Arrays.asList("");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileNameMissingStages() {
        return "./src/test/resources/SuirValley3DayStagesMissingAStage.csv";
    }

    public StageRouteMappingHolder getStageRaceStageRouteMappingHolderMissingStages() {
        String eventName = "Suir Valley 3 Day";
        Date date = utils.convertDDMMYYYYToDate("30/07/2016");
        List<String> routes = Arrays.asList("http://www.strava.com/routes/111", "http://www.strava.com/routes/222", "", "http://www.strava.com/routes/444");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileNameMixedUpStages() {
        return "./src/test/resources/SuirValley3DayStages3And4MixedUp.csv";
    }

    public List<RoadRaceEvent> getOneDayRaceWithMappedStages() {
        List<RoadRaceEvent> oneDayRaces = new ArrayList<>();
        oneDayRaces.add(getOneDayRace());
        oneDayRaces.get(0).setStageDetails(getOneDayRaceMappedStageDetails());
        
        return oneDayRaces;
    }

    private List<StageDetail> getOneDayRaceMappedStageDetails() {
        List<StageDetail> stageDetails = getOneDayRaceStageDetails();
        stageDetails.forEach(stageDetail -> {
            stageDetail.setRouteLinkUrl("http://www.strava.com/routes/123456");
        });
        
        return stageDetails;
    }

    public List<RoadRaceEvent> getStageRaceWithMappedStages() {
        List<RoadRaceEvent> stageRaces = new ArrayList<>();
        stageRaces.add(getStageRace());
        stageRaces.get(0).setStageDetails(getStageRaceMappedStageDetails());
        
        return stageRaces;
    }

    private List<StageDetail> getStageRaceMappedStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("30/07/2016"), "HEARNS HOTEL", 1, 1, "APlus,A1,A2,A3", 120.0, 74.6, "Road", "9:30", "13:00", "http://www.strava.com/routes/111"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), "HEARNS HOTEL", 1, 2, "APlus,A1,A2,A3", 92.0, 57.2, "Road", "9:30", "11:00", "http://www.strava.com/routes/222"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), "HEARNS HOTEL", 1, 3, "APlus,A1,A2,A3", 35.0, 21.7, "Criterium", "18:00", "19:00", "http://www.strava.com/routes/333"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("01/08/2016"), "HEARNS HOTEL", 1, 4, "APlus,A1,A2,A3", 122.0, 75.8, "Road", "9:30", "11:00", "http://www.strava.com/routes/444"));
        
        return stageDetails;
    }

}
