package com.lukegjpotter.spring.application.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RoadRaceEvent.class })
public class RoadRaceEventTest {

    RoadRaceEvent roadRace;
    
    @Before public void setUp() throws Exception {
        roadRace = new RoadRaceEvent();
        roadRace.setEventName("Event");
        roadRace.setPromotingClub("PromotingClub");
        roadRace.setLocation("Location");
    }

    @Test public void testToString() {
        String expected = "Event by PromotingClub in Location. Stages: 0. ";
        String actual = roadRace.toString();
        assertTrue(expected.equals(actual));
    }

}
