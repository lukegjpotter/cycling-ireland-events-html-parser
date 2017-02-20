package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, UtilsService.class })
public class UtilsServiceTest {

    @Autowired UtilsService utilsService;
    
    List<String> elements = Arrays.asList("one", "two", "three");

    @Test public void testConvertMMMMDDYYYYToDateEmptyStringCheck() {
        Date npeDate =  utilsService.convertMMMMDDYYYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date(0L)));
    }

    @Test public void testConvertDDMMMYYToDateEmptyStringCheck() {
        Date npeDate =  utilsService.convertDDMMMYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date(0L)));
    }

    @Test public void testConvertDDMMYYYYToDateEmptyStringCheck() {
        Date npeDate =  utilsService.convertDDMMYYYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date(0L)));
    }
    
    @Test public void testIsListElementInStringElementsMatch() {
        String string = "one,two,three";
        assertTrue(utilsService.isListElementInString(string, elements));
    }
    
    @Test public void testIsListElementInStringElementsDontMatch() {
        String string = "horse";
        assertFalse(utilsService.isListElementInString(string, elements));
    }
    
    @Test public void testFormatLocationEmptyString() {
        String expected = "";
        String actual = utilsService.formatLocation("");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected == actual);
    }
    
    @Test public void testFormatLocationCommaSpace() {
        String expected = "";
        String actual = utilsService.formatLocation(", ");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatLocationStandardLocation() {
        String expected = "Rugby Club, Ballyhaunis";
        String actual = utilsService.formatLocation("Rugby Club, Ballyhaunis");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatLocationLeadingComma() {
        String expected = "Castlebar";
        String actual = utilsService.formatLocation(", Castlebar");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testExtractMonthNumberFromDateWithRealDate() {
        int expected = 8;
        Date date = new Date(1470383246000L); // 2016-08-06
        int actual = utilsService.extractMonthNumberFromDate(date);
        
        assertTrue(expected == actual);
    }
    
    @Test public void testExtractMonthNumberFromDateWithNullDate() {
        int expected = -1;
        int actual = utilsService.extractMonthNumberFromDate(null);
        
        assertTrue(expected == actual);
    }
}
