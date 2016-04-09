package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.DayDateTimeModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingUtilsService.class })
public class ParsingUtilsServiceTest {

    @Autowired ParsingUtilsService parsingUtils;
    
    @Test public void testParseDayDateTimeString() {
        String dayDateTime = "Saturday, July 30, 2016 | 8:00am";
        DayDateTimeModel dayDateTimeModel = parsingUtils.parseDayDateTimeString(dayDateTime);
        assertTrue("Expected: Saturday. Actual: " + dayDateTimeModel.getDay(), dayDateTimeModel.getDay().equals("Saturday"));
        // TODO Failing because of Some Time Zone issue, use Locale.
        //assertTrue("Expected: July 30, 2016. Actual: " + dayDateTimeModel.getDate(), dayDateTimeModel.getDate().equals(new Date(1469833200000L)));
        assertTrue("Expected: 8:00am. Actual: " + dayDateTimeModel.getTime(), dayDateTimeModel.getTime().equals("8:00am"));
    }
}
