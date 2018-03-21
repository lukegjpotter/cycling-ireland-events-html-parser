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
public class RoadRaceEventDatabaseRecordTest {

    private RoadRaceEventDatabaseRecord record;
    private StageDetail stageDetail;

    @Before
    public void setUp() {
        record = new RoadRaceEventDatabaseRecord();
        record.setEventName("Event");
        record.setPromotingClub("PromotingClub");
        record.setLocation("Location");

        stageDetail = new StageDetail();
        stageDetail.setRaceNumber(1);
        stageDetail.setStageNumber("1");
        stageDetail.setCategory("A1");
        stageDetail.setKilometers(120.0);
    }

    @Test public void testToStringNoStages() {
        String expected = "Event by PromotingClub in Location. Stages: 0.";
        String actual = record.toString();
        assertTrue(expected.equals(actual));
    }

    @Test public void testToStringOneStage() {
        record.addStageDetail(stageDetail);
        String expected = "Event by PromotingClub in Location. Stages: 1."
                + "\n\tRace 1: Stage 1: A1 - 120.0km";
        String actual = record.toString();
        assertTrue(expected.equals(actual));
    }

    @Test public void testEqualsOtherObject() {
        assertFalse(record.equals(new Date()));
    }

}
