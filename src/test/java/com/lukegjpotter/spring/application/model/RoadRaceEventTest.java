package com.lukegjpotter.spring.application.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoadRaceEventTest {

    private RoadRaceEvent roadRace;
    private StageDetail stageDetail;

    @Before
    public void setUp() {
        roadRace = new RoadRaceEvent();
        roadRace.setEventName("Event");
        roadRace.setPromotingClub("PromotingClub");
        roadRace.setLocation("Location");

        stageDetail = new StageDetail();
        stageDetail.setStageName("Stage 1");
        stageDetail.setCategory("A1");
        stageDetail.setKilometers(120D);
    }

    @Test public void testToStringNoStages() {
        String expected = "Event by PromotingClub in Location. Stages: 0.";
        String actual = roadRace.toString();
        assertTrue(expected.equals(actual));
    }

    @Test public void testToStringOneStage() {
        roadRace.addStageDetail(stageDetail);
        String expected = "Event by PromotingClub in Location. Stages: 1."
                + "\n\tStage 1: A1 - 120.0km";
        String actual = roadRace.toString();

        String failMessage = String.format("Expected: %s\nActual: %s", expected, actual);

        assertTrue(failMessage, expected.equals(actual));
    }

    @Test public void testEqualsOtherObject() {
        assertFalse(roadRace.equals(new Date()));
    }

}
