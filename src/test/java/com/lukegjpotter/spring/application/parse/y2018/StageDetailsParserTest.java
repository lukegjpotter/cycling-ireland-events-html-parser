package com.lukegjpotter.spring.application.parse.y2018;

import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.testresources.StageDetailsParserTestResources;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StageDetailsParserTest {

    @Autowired
    private StageDetailsParser stageDetailsParser;
    @Autowired
    private StageDetailsParserTestResources tr;

    @Before
    public void setUp() {
    }

    @Test public void testParse() {

        List<StageDetail> actualStageDetails = stageDetailsParser.parse(tr.getJsoupElementFromPopup());

        StageDetail actual = actualStageDetails.get(0);
        StageDetail expected = tr.getExpectedOldcastleStageDetail();

        String failDate = String.format("Date: Actual: %s, Expected: %s", actual.getDate(), expected.getDate());
        String failLocation = String.format("Location: Actual: %s, Expected: %s", actual.getVenue(), expected.getVenue());
        String failRaceNumber = String.format("RaceNumber: Actual: %s, Expected: %s", actual.getRaceNumber(), expected.getRaceNumber());
        String failStageNumber = String.format("StageNumber: Actual: %s, Expected: %s", actual.getStageNumber(), expected.getStageNumber());
        String failRaceType = String.format("RaceType: Actual: %s, Expected: %s", actual.getRaceType(), expected.getRaceType());
        String failKilometers = String.format("Kilometers: Actual: %s, Expected: %s", actual.getKilometers(), expected.getKilometers());
        String failMiles = String.format("Miles: Actual: %s, Expected: %s", actual.getMiles(), expected.getMiles());
        String failCategory = String.format("Category: Actual: %s, Expected: %s", actual.getCategory(), expected.getCategory());
        String failSignOnTime = String.format("SignOnTime: Actual: %s, Expected: %s", actual.getSignOnTime(), expected.getSignOnTime());
        String failStartTime = String.format("StartTime: Actual: %s, Expected: %s", actual.getStartTime(), expected.getStartTime());
        String failRouteLinkUrl = String.format("RouteLinkUrl: Actual: %s, Expected: %s", actual.getRouteLinkUrl(), expected.getRouteLinkUrl());
        String failStageName = String.format("StageName: Actual: %s, Expected: %s", actual.getStageName(), expected.getStageName());

        assertTrue(failDate, actual.getDate().equals(expected.getDate()));
        assertTrue(failStartTime, actual.getStartTime().equals(expected.getStartTime()));
        assertTrue(failStageName, actual.getStageName().equals(expected.getStageName()));
        assertTrue(failKilometers, actual.getKilometers().equals(expected.getKilometers()));
        assertTrue(failCategory, actual.getCategory().equals(expected.getCategory()));
        assertTrue(failRaceType, actual.getRaceType().equals(expected.getRaceType()));
        assertTrue(failLocation, actual.getVenue().equals(expected.getVenue()));

//        assertTrue(failRaceNumber,actual.getRaceNumber() == 1);
//        assertTrue(failStageNumber, actual.getStageNumber().equals("1"));
//        assertTrue(failMiles, actual.getMiles().equals(62.1));
//        assertTrue(failSignOnTime, actual.getSignOnTime().equals("09:00"));
//        assertTrue(failRouteLinkUrl, actual.getRouteLinkUrl().equals(""));
    }

    @Test public void testParseAddress() {
        String actual = stageDetailsParser.parseAddress(tr.getJsoupElementFromPopup());
        String expected = tr.getExpectedOldcastleAddress();

        String failMessage = String.format("Actual: %s, Expected: %s", actual, expected);

        assertTrue(failMessage, actual.equals(expected));
    }

    @Ignore @Test public void testParseWithErrorPage() {
        // TODO: Use the file "StagesError.html" to ensure that the content loaded is of the correct format.
    }
}
