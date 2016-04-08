package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.List;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.Utils;

/**
 * This class is to reduce the boilerplate needed to create Road Race Events in the other actual test classes.
 * @author lukegjpotter
 */
public class RoadRaceEventTestResources {

    public static final String ONE_DAY_RACE_FILE_LOCATION = "./src/test/resources/DungarvanOpenRace.html";
    public static final String STAGE_RACE_FILE_LOCATION = "./src/test/resources/SuirValley3Day.html";

    /**
     * Gets a List with only one One Day Race in it.
     * @return List of one One Day Race.
     */
    public static List<RoadRaceEvent> getOneDayRaceList() {
       
        List<RoadRaceEvent> oneDayRaces = new ArrayList<>();
        oneDayRaces.add(getOneDayRace());
        
        return oneDayRaces;
    }

    /**
     * Gets a One Day Race.
     * @return {@link RoadRaceEvent} for a one day race.
     */
    public static RoadRaceEvent getOneDayRace() {
        
        RoadRaceEvent oneDayRace = getOneDayRaceHeader();
        oneDayRace.setStageDetails(getOneDayRaceStageDetails());
        
        return oneDayRace;
    }

    /**
     * Gets the header part of a One Day Race {@link RoadRaceEvent}. This does not include the {@link StageDetail} List.
     * @return {@link RoadRaceEvent} with only the headers filled in.
     */
    public static RoadRaceEvent getOneDayRaceHeader() {
        
        RoadRaceEvent oneDayRace = new RoadRaceEvent();
        oneDayRace.setStartDate(Utils.convertStringToDate("03-Apr-16", Constants.DATE_FORMAT_DD_MMM_YY));
        oneDayRace.setEventName("Dungarvan Open Race");
        oneDayRace.setPromotingClub("Dungarvan CC");
        oneDayRace.setOrganiser("John Coleman");
        oneDayRace.setRegisterationLink(""); // TODO Parse this from CI Website.
        oneDayRace.setBookingsOpenDate(Utils.convertStringToDate("03/04/2016", Constants.DATE_FORMAT_DDMMYYYY));
        oneDayRace.setBookingsCloseDate(Utils.convertStringToDate("03/04/2016", Constants.DATE_FORMAT_DDMMYYYY));
        oneDayRace.setOrganiserPhoneNumber("+353858500404");
        oneDayRace.setOrganiserEmail("john.coleman@mts.ie");
        oneDayRace.setLocation("Soccer Club, Dungarvan");
        oneDayRace.setProvince("Munster");
        return oneDayRace;
    }

    /**
     * Gets the {@link StageDetail} for a One Day Race.
     * @return {@link List} contatining {@link StageDetail} objects.
     */
    public static List<StageDetail> getOneDayRaceStageDetails() {
        
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 1, 1, "A1", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 2, 1, "A2", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 3, 1, "A3", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 4, 1, "A4", 70, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 6, 1, "U14", 18, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 8, 1, "Women", 70, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
        return stageDetails;
    }
    
    /**
     * Gets a List of a Stage Race {@link RoadRaceEvent}. It will contain one Stage Race.
     * @return {@link List} containing one Stage Race.
     */
    public static List<RoadRaceEvent> getStageRaceList() {
        
        List<RoadRaceEvent> stageRaces = new ArrayList<>();
        stageRaces.add(getStageRace());
        
        return stageRaces;
    }

    /**
     * Gets a stage race.
     * @return {@link RoadRaceEvent} for  stage race.
     */
    public static RoadRaceEvent getStageRace() {
        
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
    public static List<StageDetail> getStageRaceStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail("30/07/2016", 1, 1, "APlus,A1,A2,A3", 120, 74.6, "Road", "9.30", "13.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail("31/07/2016", 1, 2, "APlus,A1,A2,A3", 92, 57.2, "Road", "9.30", "11.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail("31/07/2016", 1, 3, "APlus,A1,A2,A3", 35, 21.7, "Criterium", "18.00", "19.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail("01/08/2016", 1, 4, "APlus,A1,A2,A3", 122, 75.8, "Road", "9.30", "11.00", "http://www.suirvalley3day.com/"));
        return stageDetails;
    }
}
