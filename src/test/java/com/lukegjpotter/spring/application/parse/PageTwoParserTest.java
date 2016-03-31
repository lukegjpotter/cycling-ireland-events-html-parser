package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

public class PageTwoParserTest {

    Parser parser;
    RoadRaceEvent expected;
    
    @Before
    public void setUp() throws Exception {
        String pageLocation = "./src/test/resources/Page2-SuirValleyThreeDay.html";
        parser = ParserFactory.getPageOneParser(pageLocation);
        
        expected = null;
    }

    @Test(expected = NullPointerException.class)
    public void testParse() {
        RoadRaceEvent actual = parser.parse();
        
        assertTrue("Expected: " + expected.getSignOnLocation() + ". Actual: " + actual.getSignOnLocation(), expected.getSignOnLocation().equals(actual.getSignOnLocation()));
        assertTrue("Expected: " + expected.getEndDate() + ". Actual: " + actual.getEndDate(), expected.getEndDate().equals(actual.getEndDate()));
        assertTrue("Expected: " + expected.getStageDetails() + ". Actual: " + actual.getStageDetails(), expected.getStageDetails().equals(actual.getStageDetails()));
    }
}
