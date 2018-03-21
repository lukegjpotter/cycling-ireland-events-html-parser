package com.lukegjpotter.spring.application.service;

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
public class UrlMonthServiceTest {

    @Autowired
    private UrlMonthService urlMonthService;

    @Before
    public void setUp() {
    }

    @Test public void testCompileUrlsForRemainYearMonths() {

        String expectedDecemberUrl = "http://www.calendarwiz.com/calendars/calendar.php?crd=CyclingirelandRoad&op=cal&month=12&year=2017";
        List<String> actualUrls = urlMonthService.compileUrlsForRemainingYearMonths();

        assertTrue(actualUrls.contains(expectedDecemberUrl));
    }

}
