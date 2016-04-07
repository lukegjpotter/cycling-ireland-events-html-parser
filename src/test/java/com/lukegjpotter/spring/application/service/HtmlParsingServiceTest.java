package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class,
        HtmlParsingService.class })
public class HtmlParsingServiceTest {

    @Autowired
    private HtmlParsingService htmlParsingService;
    @Autowired
    private ParsingLoop parsingLoop;
    
    @Before
    public void setUp() {
        
        parsingLoop = mock(ParsingLoop.class);
    }

    @Test
    public void testParseOneDayRace() {
        
        List<RoadRaceEvent> expected = setupOneDayRaceTestResources();
        when(parsingLoop.startParseLoop("")).thenReturn(expected);
        List<RoadRaceEvent> actual = htmlParsingService.parse();
        assertTrue(expected.equals(actual));
    }

    @Test
    @Ignore
    public void testParseStageRace() {
        RoadRaceEvent expected = setupStageRaceTestResources();
        RoadRaceEvent actual = htmlParsingService.parse().get(0);
        assertTrue(expected.equals(actual));
    }

    private List<RoadRaceEvent> setupOneDayRaceTestResources() {
        RoadRaceEvent oneDayRace;
        List<StageDetail> stageDetails = new ArrayList<>();
        htmlParsingService.setHtmlFileLocation("./src/test/resources/DungarvanOpenRace.html");
        
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
        
        List<RoadRaceEvent> oneDayRaces = new ArrayList<>();
        oneDayRaces.add(oneDayRace);
        
        return oneDayRaces;
    }
    
    private RoadRaceEvent setupStageRaceTestResources() {
        RoadRaceEvent stageRace;
        List<StageDetail> stageDetails = new ArrayList<>();

        htmlParsingService.setHtmlFileLocation("./src/test/resources/SuirValley3Day.html");

        stageRace = new RoadRaceEvent();
        /*"Suir Valley 3 Day", "Saturday", "July 30, 2016", "8:00am", "Munster", "Road",
                "Clonmel CC", "Declan Byrne", "declanbyrne2006@gmail.com", "3.53879E+11",
                "https://cyclingireland.azolve.com/portal/Moreeventdetails.aspx?EventId=213961", "Munster, Munster");*/

        stageDetails.add(new StageDetail("30/07/2016", 1, 1, "APlus,A1,A2,A3", 120, 74.6, "Road", "9.30", "13.00",
                "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail("31/07/2016", 1, 2, "APlus,A1,A2,A3", 92, 57.2, "Road", "9.30", "11.00",
                "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail("31/07/2016", 1, 3, "APlus,A1,A2,A3", 35, 21.7, "Criterium", "18.00",
                "19.00", "http://www.suirvalley3day.com/"));
        stageDetails.add(new StageDetail("01/08/2016", 1, 4, "APlus,A1,A2,A3", 122, 75.8, "Road", "9.30", "11.00",
                "http://www.suirvalley3day.com/"));

//        stageRace.setSignOnLocation("HEARNS HOTEL, CLONMEL");
//        stageRace.setEndDate(Utils.convertStringToDate("01/08/2016", Constants.DATE_FORMAT_DDMMYYYY));
        stageRace.setStageDetails(stageDetails);

        return stageRace;
    }
}
