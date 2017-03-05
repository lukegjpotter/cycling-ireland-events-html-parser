package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, UrlMonthService.class })
public class UrlMonthServiceTest {
    
    @Autowired UrlMonthService urlMonthService;

    @Before public void setUp() throws Exception {}

    @Test public void testCompileUrlsForRemainYearMonths() {
        
        String expectedDecemberUrl = "http://www.calendarwiz.com/calendars/calendar.php?crd=CyclingirelandRoad&op=cal&month=12&year=2017";
        List<String> actualUrls = urlMonthService.compileUrlsForRemainYearMonths();
        
        assertTrue(actualUrls.contains(expectedDecemberUrl));
    }

}
