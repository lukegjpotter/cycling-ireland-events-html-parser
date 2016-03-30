package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

public class PageOneParserTest {
    
    Parser parser;
    RoadRaceEvent expected;

    @Before
    public void setUp() throws Exception {
        String pageLocation = "./src/test/resources/Page1-SuirValleyThreeDay.html";
        parser = ParserFactory.getPageOneParser(pageLocation);
        
        expected = new RoadRaceEvent("Suir Valley 3 Day", "Saturday", "July 30, 2016", "8:00am", "Munster",
                "Road", "Clonmel CC", "Declan Byrne", "declanbyrne2006@gmail.com", "3.53879E+11",
                "https://cyclingireland.azolve.com/portal/Moreeventdetails.aspx?EventId=213961", "Munster, Munster");
    }

    @Test
    public void testParse() {
        RoadRaceEvent actual = parser.parse();
        
        assertTrue("Expected: " + expected.getEventName() + ". Actual: " + actual.getEventName(), expected.getEventName().equals(actual.getEventName()));
        assertTrue("Expected: " + expected.getStartDay() + ". Actual: " + actual.getStartDay(), expected.getStartDay().equals(actual.getStartDay()));
        assertTrue("Expected: " + expected.getStartDate() + ". Actual: " + actual.getStartDate(), expected.getStartDate().equals(actual.getStartDate()));
        assertTrue("Expected: " + expected.getSignOnTime() + ". Actual: " + actual.getSignOnTime(), expected.getSignOnTime().equals(actual.getSignOnTime()));
        assertTrue("Expected: " + expected.getProvince() + ". Actual: " + actual.getProvince(), expected.getProvince().equals(actual.getProvince()));
        assertTrue("Expected: " + expected.getCategory() + ". Actual: " + actual.getCategory(), expected.getCategory().equals(actual.getCategory()));
        assertTrue("Expected: " + expected.getPromotingClub() + ". Actual: " + actual.getPromotingClub(), expected.getPromotingClub().equals(actual.getPromotingClub()));
        assertTrue("Expected: " + expected.getPrimaryContactPerson() + ". Actual: " + actual.getPrimaryContactPerson(), expected.getPrimaryContactPerson().equals(actual.getPrimaryContactPerson()));
        assertTrue("Expected: " + expected.getPrimaryContactEmail() + ". Actual: " + actual.getPrimaryContactEmail(), expected.getPrimaryContactEmail().equals(actual.getPrimaryContactEmail()));
        assertTrue("Expected: " + expected.getPrimaryContactPhoneNumber() + ". Actual: " + actual.getPrimaryContactPhoneNumber(), expected.getPrimaryContactPhoneNumber().equals(actual.getPrimaryContactPhoneNumber()));
        assertTrue("Expected: " + expected.getMoreInfoUrl() + ". Actual: " + actual.getMoreInfoUrl(), expected.getMoreInfoUrl().equals(actual.getMoreInfoUrl()));
        assertTrue("Expected: " + expected.getLocationDetails() + ". Actual: " + actual.getLocationDetails(), expected.getLocationDetails().equals(actual.getLocationDetails()));
    }
}
