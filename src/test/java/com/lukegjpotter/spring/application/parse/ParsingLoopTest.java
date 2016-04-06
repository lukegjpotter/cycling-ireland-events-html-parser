package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class,
        ParsingLoop.class })
public class ParsingLoopTest {

    @Autowired ParsingLoop parsingLoop;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testStartParseLoopOneDayRace() {
        RoadRaceEvent actual = parsingLoop.startParseLoop("./src/test/resources/DungarvanOpenRace.html").get(0);
        RoadRaceEvent expected = setupOneDayRaceTestResources();
        
        assertTrue(actual.equals(expected));
    }
    
    private RoadRaceEvent setupOneDayRaceTestResources() {
        
        RoadRaceEvent race;
        List<StageDetail> stageDetails = new ArrayList<>();
        
        race = new RoadRaceEvent();
        race.setStartDate(Utils.convertStringToDate("03-Apr-16", Constants.DATE_FORMAT_DD_MMM_YY));
        race.setEventName("Dungarvan Open Race");
        race.setPromotingClub("Dungarvan CC");
        race.setOrganiser("John Coleman");
        race.setRegisterationLink(""); // TODO Parse this from CI Website.
        race.setBookingsOpenDate(Utils.convertStringToDate("03/04/2016", Constants.DATE_FORMAT_DDMMYYYY));
        race.setBookingsCloseDate(Utils.convertStringToDate("03/04/2016", Constants.DATE_FORMAT_DDMMYYYY));
        race.setOrganiserPhoneNumber("+353858500404");
        race.setOrganiserEmail("john.coleman@mts.ie");
        race.setLocation("Soccer Club, Dungarvan");
        race.setProvince("Munster");
        
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 1, 1, "A1", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 2, 1, "A2", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 3, 1, "A3", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 4, 1, "A4", 70, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 6, 1, "U14", 18, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 8, 1, "Women", 70, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
        
        race.setStageDetails(stageDetails);
        
        return race;
    }
}
