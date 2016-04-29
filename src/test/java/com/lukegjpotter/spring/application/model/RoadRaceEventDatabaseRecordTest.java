package com.lukegjpotter.spring.application.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RoadRaceEventDatabaseRecord.class })
public class RoadRaceEventDatabaseRecordTest {

    RoadRaceEventDatabaseRecord record;
    
    @Before public void setUp() throws Exception {
        record = new RoadRaceEventDatabaseRecord();
        record.setEventName("Event");
        record.setPromotingClub("PromotingClub");
        record.setLocation("Location");
    }

    @Test public void testToString() {
        String expected = "Event by PromotingClub in Location. Stages: 0. ";
        String actual = record.toString();
        assertTrue(expected.equals(actual));
    }

}
