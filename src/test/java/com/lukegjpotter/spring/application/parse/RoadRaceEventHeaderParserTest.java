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
        RoadRaceEventHeaderParser.class })
public class RoadRaceEventHeaderParserTest {

    @Autowired
    RoadRaceEventHeaderParser roadRaceEventHeaderParser;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testParseOneDayRace() {
        RoadRaceEvent actual = roadRaceEventHeaderParser.parse("");
        RoadRaceEvent expected = setupOneDayRaceTestResources();

        assertTrue(actual.equals(expected));
    }

    private RoadRaceEvent setupOneDayRaceTestResources() {

        RoadRaceEvent race;

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
        
        return race;
    }
}
