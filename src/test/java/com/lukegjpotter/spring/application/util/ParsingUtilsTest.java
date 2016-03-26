package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.lukegjpotter.spring.application.model.DayDateTimeModel;

public class ParsingUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testParseDayDateTimeString() {
        
        String dayDateTime = "Saturday, July 30, 2016 | 8:00am";
        
        DayDateTimeModel dayDateTimeModel = ParsingUtils.parseDayDateTimeString(dayDateTime);
        
        assertTrue("Expected: Saturday. Actual: " + dayDateTimeModel.getDay(), dayDateTimeModel.getDay().equals("Saturday"));
        assertTrue("Expected: July 30, 2016. Actual: " + dayDateTimeModel.getDate(), dayDateTimeModel.getDate().equals(new Date(1469833200000L)));
        assertTrue("Expected: 8:00am. Actual: " + dayDateTimeModel.getTime(), dayDateTimeModel.getTime().equals("8:00am"));
    }
}
