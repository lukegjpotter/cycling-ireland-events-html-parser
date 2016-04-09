package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventTestResources;
import com.lukegjpotter.spring.application.testresources.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RoadRaceEventHeaderParser.class })
public class RoadRaceEventHeaderParserTest {

    @Autowired RoadRaceEventHeaderParser roadRaceEventHeaderParser;
    @Autowired RoadRaceEventTestResources rretr;
    @Autowired TestUtils utils;

    @Test public void testParseOneDayRace() {
        RoadRaceEvent actual = roadRaceEventHeaderParser.parse(utils.roadRaceHeaderRawHtml());
        RoadRaceEvent expected = rretr.getOneDayRaceHeader();
        
        assertTrue("StartDate: Expected: " + expected.getStartDate() + ". Actual: " + actual.getStartDate(), expected.getStartDate().equals(actual.getStartDate()));
        assertTrue("EventName: Expected: " + expected.getEventName() + ". Actual: " + actual.getEventName(), expected.getEventName().equals(actual.getEventName()));
        assertTrue("PromotingClub: Expected: " + expected.getPromotingClub() + ". Actual: " + actual.getPromotingClub(), expected.getPromotingClub().equals(actual.getPromotingClub()));
        assertTrue("Organiser: Expected: " + expected.getOrganiser() + ". Actual: " + actual.getOrganiser(), expected.getOrganiser().equals(actual.getOrganiser()));
    }

}
