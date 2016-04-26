package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertTrue;

import java.util.Date;

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

    @Test(expected = NullPointerException.class)
    public void testConvertMMMMDDYYYYToDate_NPECheck() {
        Date npeDate =  utilsService.convertMMMMDDYYYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDDMMMYYToDate_NPECheck() {
        Date npeDate =  utilsService.convertDDMMMYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDDMMYYYYToDate_NPECheck() {
        Date npeDate =  utilsService.convertDDMMYYYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }
    
    @Test public void testFormatLocationEmptyString() {
        String expected = "";
        String actual = utilsService.formatLocation("");
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testFormatLocationStandardLocation() {
        String expected = "Rugby Club, Ballyhaunis";
        String actual = utilsService.formatLocation("Rugby Club, Ballyhaunis");
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testFormatLocationLeadingComma() {
        String expected = "Castlebar";
        String actual = utilsService.formatLocation(", Castlebar");
        assertTrue(expected.equals(actual));
    }

}
