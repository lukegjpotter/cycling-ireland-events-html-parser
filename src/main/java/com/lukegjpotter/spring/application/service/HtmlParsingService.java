package com.lukegjpotter.spring.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.parse.ParserFactory;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.Utils;

@Service
public class HtmlParsingService {

    private String htmlFileLocation;

    public List<RoadRaceEvent> parse() {
        
        List<RoadRaceEvent> races = new ArrayList<>();
        RoadRaceEvent oneDayRace;
        List<StageDetail> stageDetails = new ArrayList<>();
        
        oneDayRace = new RoadRaceEvent();
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
        
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 1, 1, "A1", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 2, 1, "A2", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 3, 1, "A3", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 4, 1, "A4", 70, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 6, 1, "U14", 18, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 8, 1, "Women", 70, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
        
        oneDayRace.setStageDetails(stageDetails);
        races.add(oneDayRace);
        
        return races;
    }

    public void setHtmlFileLocation(String htmlFileLocation) {
        this.htmlFileLocation = htmlFileLocation;
    }
}
