package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.testresources.TestResources;
import com.lukegjpotter.spring.application.testresources.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, StageDetailParser.class })
public class StageDetailParserTest {

    @Autowired StageDetailParser stageDetailParser;
    @Autowired TestResources tr;
    @Autowired TestUtils utils;

    @Test public void testParseOneDayRace() {
        List<StageDetail> actual = stageDetailParser.parse(utils.oneDayRaceStageDetailRawHtml());
        List<StageDetail> expected = tr.getOneDayRaceStageDetails();
        
        assertTrue("Lists are not the same size", expected.size() == actual.size());
        
        for (int i = 0; i < expected.size(); i++) {
            StageDetail e = expected.get(i), a = actual.get(i);
            
            assertTrue(i + " Date Expected: " + e.getDate() + ". Actual: " + a.getDate(), e.getDate().equals(a.getDate()));
            assertTrue(i + " Location Expected: " + e.getLocation() + ". Actual: " + a.getLocation(), e.getLocation().equals(a.getLocation()));
            assertTrue(i + " RaceNumber Expected: " + e.getRaceNumber() + ". Actual: " + a.getRaceNumber(), e.getRaceNumber() == a.getRaceNumber());
            assertTrue(i + " StageNumber Expected: " + e.getStageNumber() + ". Actual: " + a.getStageNumber(), e.getStageNumber() == a.getStageNumber());
            assertTrue(i + " RaceType Expected: " + e.getRaceType() + ". Actual: " + a.getRaceType(), e.getRaceType().equals(a.getRaceType()));
            assertTrue(i + " Kilometers Expected: " + e.getKilometers() + ". Actual: " + a.getKilometers(), e.getKilometers() == a.getKilometers());
            assertTrue(i + " Miles Expected: " + e.getMiles() + ". Actual: " + a.getMiles(), e.getMiles() == a.getMiles());
            assertTrue(i + " Category Expected: " + e.getCategory() + ". Actual: " + a.getCategory(), e.getCategory().equals(a.getCategory()));
            assertTrue(i + " SignOnTime Expected: " + e.getSignOnTime() + ". Actual: " + a.getSignOnTime(), e.getSignOnTime().equals(a.getSignOnTime()));
            assertTrue(i + " StartTime Expected: " + e.getStartTime() + ". Actual: " + a.getStartTime(), e.getStartTime().equals(a.getStartTime()));
            assertTrue(i + " RouteLinkUrl Expected: " + e.getRouteLinkUrl() + ". Actual: " + a.getRouteLinkUrl(), e.getRouteLinkUrl().equals(a.getRouteLinkUrl()));
        }
        
        assertTrue("Lists are not exactly the same.", expected.equals(actual));
    }
    
    @Test public void testParseStageRace() {
        List<StageDetail> actual = stageDetailParser.parse(utils.stageRaceStageDetailRawHtml());
        List<StageDetail> expected = tr.getStageRaceStageDetails();
        
        assertTrue("Lists are not the same size", expected.size() == actual.size());
        
        for (int i = 0; i < expected.size(); i++) {
            StageDetail e = expected.get(i), a = actual.get(i);
            
            assertTrue(i + " Date Expected: " + e.getDate() + ". Actual: " + a.getDate(), e.getDate().equals(a.getDate()));
            assertTrue(i + " Location Expected: " + e.getLocation() + ". Actual: " + a.getLocation(), e.getLocation().equals(a.getLocation()));
            assertTrue(i + " RaceNumber Expected: " + e.getRaceNumber() + ". Actual: " + a.getRaceNumber(), e.getRaceNumber() == a.getRaceNumber());
            assertTrue(i + " StageNumber Expected: " + e.getStageNumber() + ". Actual: " + a.getStageNumber(), e.getStageNumber() == a.getStageNumber());
            assertTrue(i + " RaceType Expected: " + e.getRaceType() + ". Actual: " + a.getRaceType(), e.getRaceType().equals(a.getRaceType()));
            assertTrue(i + " Kilometers Expected: " + e.getKilometers() + ". Actual: " + a.getKilometers(), e.getKilometers() == a.getKilometers());
            assertTrue(i + " Miles Expected: " + e.getMiles() + ". Actual: " + a.getMiles(), e.getMiles() == a.getMiles());
            assertTrue(i + " Category Expected: " + e.getCategory() + ". Actual: " + a.getCategory(), e.getCategory().equals(a.getCategory()));
            assertTrue(i + " SignOnTime Expected: " + e.getSignOnTime() + ". Actual: " + a.getSignOnTime(), e.getSignOnTime().equals(a.getSignOnTime()));
            assertTrue(i + " StartTime Expected: " + e.getStartTime() + ". Actual: " + a.getStartTime(), e.getStartTime().equals(a.getStartTime()));
            assertTrue(i + " RouteLinkUrl Expected: " + e.getRouteLinkUrl() + ". Actual: " + a.getRouteLinkUrl(), e.getRouteLinkUrl().equals(a.getRouteLinkUrl()));
        }
        
        assertTrue("Lists are not exactly the same.", expected.equals(actual));
    }

}
