package com.lukegjpotter.spring.application.parse.y2018;

import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.testresources.StageDetailsParserTestResources;
import org.junit.Before;
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
        String failStageName = String.format("StageName: Actual: %s, Expected: %s", actual.getStageName(), expected.getStageName());
        String failKilometers = String.format("Kilometers: Actual: %s, Expected: %s", actual.getKilometers(), expected.getKilometers());
        String failCategory = String.format("Category: Actual: %s, Expected: %s", actual.getCategory(), expected.getCategory());
        String failRaceType = String.format("RaceType: Actual: %s, Expected: %s", actual.getRaceType(), expected.getRaceType());
        String failStartTime = String.format("StartTime: Actual: %s, Expected: %s", actual.getStartTime(), expected.getStartTime());
        String failRouteLinkUrl = String.format("RouteLinkUrl: Actual: %s, Expected: %s", actual.getRouteLinkUrl(), expected.getRouteLinkUrl());

        assertTrue(failDate, actual.getDate().equals(expected.getDate()));
        assertTrue(failStartTime, actual.getStartTime().equals(expected.getStartTime()));
        assertTrue(failStageName, actual.getStageName().equals(expected.getStageName()));
        assertTrue(failKilometers, actual.getKilometers().equals(expected.getKilometers()));
        assertTrue(failCategory, actual.getCategory().equals(expected.getCategory()));
        assertTrue(failRaceType, actual.getRaceType().equals(expected.getRaceType()));
        assertTrue(failLocation, actual.getVenue().equals(expected.getVenue()));
        assertTrue(failRouteLinkUrl, actual.getRouteLinkUrl().equals(expected.getRouteLinkUrl()));
    }

    @Test public void testParseAddress() {
        String actual = stageDetailsParser.parseAddress(tr.getJsoupElementFromPopup());
        String expected = tr.getExpectedOldcastleAddress();

        String failMessage = String.format("Actual: %s, Expected: %s", actual, expected);

        assertTrue(failMessage, actual.equals(expected));
    }
}
