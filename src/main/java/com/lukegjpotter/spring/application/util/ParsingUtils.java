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
        
        String[] dayDateTimeStringArray = dayDateTime.split(",", 2);
        String day = dayDateTimeStringArray[0].trim();
        String [] dateAndTimeStringArray = dayDateTimeStringArray[1].split("\\|");
        String date = dateAndTimeStringArray[0].trim();
        String time = dateAndTimeStringArray[1].trim();
        
        return new DayDateTimeModel(day, date, time);
    }
}
