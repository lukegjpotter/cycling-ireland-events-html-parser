package com.lukegjpotter.spring.application.parse.y2016;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.Description;
import com.lukegjpotter.spring.application.parse.y2016.DescriptionParser;
import com.lukegjpotter.spring.application.testresources.TestResources;
import com.lukegjpotter.spring.application.testresources.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, DescriptionParser.class })
public class DescriptionParserTest {

    @Autowired DescriptionParser descriptionParser;
    @Autowired TestResources tr;
    @Autowired TestUtils utils;
    
    @Ignore
    @Test public void testParseOneDayRace() {
        Description actual = descriptionParser.parse(utils.oneDayRaceDescriptionRawHtml());
        Description expected = tr.getOneDayRaceDescription();
        performTestChecks(actual, expected);
    }
    
    @Ignore
    @Test public void testParseStageRace() {
        Description actual = descriptionParser.parse(utils.stageRaceDescriptionRawHtml());
        Description expected = tr.getStageRaceDescription();
        performTestChecks(actual, expected);
    }
    
    @Ignore
    @Test public void testParseEmptyDescriptionElements() {
        Description actual = descriptionParser.parse(utils.emptyDescriptionRawHtml());
        Description expected = new Description();
        assertTrue(expected.equals(actual));
    }

    private void performTestChecks(Description actual, Description expected) {
        assertTrue("BookingsOpenDate: Expected: " + expected.getBookingsOpenDate() + ". Actual: " + actual.getBookingsOpenDate(), expected.getBookingsOpenDate().equals(actual.getBookingsOpenDate()));
        assertTrue("BookingsCloseDate: Expected: " + expected.getBookingsCloseDate() + ". Actual: " + actual.getBookingsCloseDate(), expected.getBookingsCloseDate().equals(actual.getBookingsCloseDate()));
        assertTrue("OrganiserPhoneNumber: Expected: " + expected.getOrganiserPhoneNumber() + ". Actual: " + actual.getOrganiserPhoneNumber(), expected.getOrganiserPhoneNumber().equals(actual.getOrganiserPhoneNumber()));
        assertTrue("OrganiserEmail: Expected: " + expected.getOrganiserEmail() + ". Actual: " + actual.getOrganiserEmail(), expected.getOrganiserEmail().equals(actual.getOrganiserEmail()));
        assertTrue("Location: Expected: " + expected.getLocation() + ". Actual: " + actual.getLocation(), expected.getLocation().equals(actual.getLocation()));
        //assertTrue("Province: Expected: " + expected.getProvince() + ". Actual: " + actual.getProvince(), expected.getProvince().equals(actual.getProvince()));
        assertTrue(expected.equals(actual));
    }

}
