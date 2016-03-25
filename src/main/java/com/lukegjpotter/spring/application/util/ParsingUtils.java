package com.lukegjpotter.spring.application.util;

import com.lukegjpotter.spring.application.model.DayDateTimeModel;

public class ParsingUtils {

    /**
     * Parses a string containing the Day, Date and Time into a DayDateTimeModel.
     * The expected format is "DAY, Month Day, Year | 12HourTime"
     * E.G. "Saturday, July 30, 2016 | 8:00am"
     * 
     * @param dayDateTime
     * @return Populated DayDateTimeModel
     */
    public static DayDateTimeModel parseDayDateTimeString(String dayDateTime) {
        
        String day = dayDateTime.split(",", 2)[0];
        String [] dateAndTimeStringArray = dayDateTime.split("|");
        String date = dateAndTimeStringArray[0];
        String time = dateAndTimeStringArray[1];
        
        return new DayDateTimeModel(day, date, time);
    }
}
