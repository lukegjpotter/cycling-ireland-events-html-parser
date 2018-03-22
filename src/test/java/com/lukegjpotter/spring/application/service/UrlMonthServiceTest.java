package com.lukegjpotter.spring.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UrlMonthServiceTest {

    @Autowired
    private UrlMonthService urlMonthService;

    @Test public void testCompileUrlsForRemainYearMonths() {

        String expectedDecemberUrl = "http://www.calendarwiz.com/calendars/calendar.php?crd=CyclingirelandRoad&op=cal&month=12&year=2018";
        List<String> actualUrls = urlMonthService.compileUrlsForRemainingYearMonths();

        String failMessage = String.format("Expected: %s\nActual List: %s", expectedDecemberUrl, actualUrls);

        assertTrue(failMessage, actualUrls.contains(expectedDecemberUrl));
    }

}
