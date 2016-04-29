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
    StageDetail stageDetail;
    
    @Before public void setUp() throws Exception {
        roadRace = new RoadRaceEvent();
        roadRace.setEventName("Event");
        roadRace.setPromotingClub("PromotingClub");
        roadRace.setLocation("Location");
        
        stageDetail = new StageDetail();
        stageDetail.setRaceNumber(1);
        stageDetail.setStageNumber(1);   
        stageDetail.setCategory("A1");
        stageDetail.setKilometers(120.0);
    }

    @Test public void testToStringNoStages() {
        String expected = "Event by PromotingClub in Location. Stages: 0.";
        String actual = roadRace.toString();
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testToStringOneStage() {
        roadRace.addStageDetail(stageDetail);
        String expected = "Event by PromotingClub in Location. Stages: 1."
                + "\n\tRace 1: Stage 1: A1 - 120.0km";
        String actual = roadRace.toString();
        assertTrue(expected.equals(actual));
    }

}
