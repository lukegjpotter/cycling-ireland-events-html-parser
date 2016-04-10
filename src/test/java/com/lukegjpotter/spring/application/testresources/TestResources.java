package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.Description;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
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
        description.setProvince("Munster");
        return description;
    }

    /**
     * Gets the {@link StageDetail} for a One Day Race.
     * @return {@link List} containing {@link StageDetail} objects.
     */
    public List<StageDetail> getOneDayRaceStageDetails() {
        
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "A1", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 2, 1, "A2", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 3, 1, "A3", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 4, 1, "A4", 70, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 6, 1, "U14", 18, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 8, 1, "Women", 70, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
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
        
        RoadRaceEvent stageRace = new RoadRaceEvent();
        
        /*"Suir Valley 3 Day", "Saturday", "July 30, 2016", "8:00am", "Munster", "Road",
                "Clonmel CC", "Declan Byrne", "declanbyrne2006@gmail.com", "3.53879E+11",
                "https://cyclingireland.azolve.com/portal/Moreeventdetails.aspx?EventId=213961", "Munster, Munster");*/
        //stageRace.setSignOnLocation("HEARNS HOTEL, CLONMEL");
        //stageRace.setEndDate(Utils.convertStringToDate("01/08/2016", Constants.DATE_FORMAT_DDMMYYYY));
        stageRace.setStageDetails(getStageRaceStageDetails());
        
        return stageRace;
    }

    /**
     * Gets the {@link StageDetail} for a Stage Race.
     * @return {@link List} of {@link StageDetail} for stage race.
     */
    public List<StageDetail> getStageRaceStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("30/07/2016"), 1, 1, "APlus,A1,A2,A3", 120, 74.6, "Road", "9.30", "13.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), 1, 2, "APlus,A1,A2,A3", 92, 57.2, "Road", "9.30", "11.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), 1, 3, "APlus,A1,A2,A3", 35, 21.7, "Criterium", "18.00", "19.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("01/08/2016"), 1, 4, "APlus,A1,A2,A3", 122, 75.8, "Road", "9.30", "11.00", "http://www.suirvalley3day.com/"));
        return stageDetails;
    }
}
