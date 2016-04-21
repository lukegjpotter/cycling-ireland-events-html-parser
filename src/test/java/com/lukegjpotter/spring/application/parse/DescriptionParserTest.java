package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.Description;
import com.lukegjpotter.spring.application.testresources.TestResources;
import com.lukegjpotter.spring.application.testresources.TestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, DescriptionParser.class })
public class DescriptionParserTest {

    @Autowired DescriptionParser descriptionParser;
    @Autowired TestResources tr;
    @Autowired TestUtils utils;
    
    @Test public void testParseOneDayRace() {
        Description actual = descriptionParser.parse(utils.oneDayRaceDescriptionRawHtml());
        Description expected = tr.getOneDayRaceDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParseStageRace() {
        Description actual = descriptionParser.parse(utils.stageRaceDescriptionRawHtml());
        Description expected = tr.getStageRaceDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParsePhoneNumberWithSpace() {
        Description actual = descriptionParser.parse(utils.phoneNumberWithSpacesDescriptionRawHtml());
        Description expected = tr.getPhoneNumberWithSpacesDescription();
        performTestChecks(actual, expected);
    }
    
    @Test @Ignore public void testParsePhoneNumberNorthernIreland() {
        // TODO Add this test
    }
    
    @Test public void testParsePhoneNumberDoubleNorthernIrelandPrefix() {
        Description actual = descriptionParser.parse(utils.phoneNumberDoubleNorthernIrelandPrefixDescriptionRawHtml());
        Description expected = tr.getPhoneNumberDoubleNorthernIrelandPrefixDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParsePhoneNumberNiAndRoiAndZeroPrefix() {
        Description actual = descriptionParser.parse(utils.phoneNumberNiAndRoiAndZeroPrefixDescriptionRawHtml());
        Description expected = tr.getPhoneNumberDoubleNiAndRoiAndZeroPrefixDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParsePhoneNumberDoubleNorthernIrelandAndZeroPrefix() {
        Description actual = descriptionParser.parse(utils.phoneNumberDoubleNorthernIrelandAndZeroPrefixDescriptionRawHtml());
        Description expected = tr.getPhoneNumberDoubleNorthernIrelandAndZeroPrefixDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParsePhoneNumberNorthernIrelandAndZeroPrefix() {
        Description actual = descriptionParser.parse(utils.phoneNumberNorthernIrelandAndZeroPrefixDescriptionRawHtml());
        Description expected = tr.getPhoneNumberNorthernIrelandAndZeroPrefixDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParsePhoneNumberNorthernIrelandPrefixForIrelandNumber() {
        Description actual = descriptionParser.parse(utils.phoneNumberNorthernIrelandPrefixForIrelandNumberDescriptionRawHtml());
        Description expected = tr.getPhoneNumberNorthernIrelandPrefixForIrelandNumberDescription();
        performTestChecks(actual, expected);
    }
    
    @Test public void testParsePhoneNumberDoubleIrelandPrefix() {
        Description actual = descriptionParser.parse(utils.phoneNumberDoubleIrelandPrefixDescriptionRawHtml());
        Description expected = tr.getPhoneNumberDoubleIrelandPrefixDescription();
        performTestChecks(actual, expected);
    }

    public void performTestChecks(Description actual, Description expected) {
        assertTrue("BookingsOpenDate: Expected: " + expected.getBookingsOpenDate() + ". Actual: " + actual.getBookingsOpenDate(), expected.getBookingsOpenDate().equals(actual.getBookingsOpenDate()));
        assertTrue("BookingsCloseDate: Expected: " + expected.getBookingsCloseDate() + ". Actual: " + actual.getBookingsCloseDate(), expected.getBookingsCloseDate().equals(actual.getBookingsCloseDate()));
        assertTrue("OrganiserPhoneNumber: Expected: " + expected.getOrganiserPhoneNumber() + ". Actual: " + actual.getOrganiserPhoneNumber(), expected.getOrganiserPhoneNumber().equals(actual.getOrganiserPhoneNumber()));
        assertTrue("OrganiserEmail: Expected: " + expected.getOrganiserEmail() + ". Actual: " + actual.getOrganiserEmail(), expected.getOrganiserEmail().equals(actual.getOrganiserEmail()));
        assertTrue("Location: Expected: " + expected.getLocation() + ". Actual: " + actual.getLocation(), expected.getLocation().equals(actual.getLocation()));
        assertTrue("Province: Expected: " + expected.getProvince() + ". Actual: " + actual.getProvince(), expected.getProvince().equals(actual.getProvince()));
        assertTrue(expected.equals(actual));
    }

}
