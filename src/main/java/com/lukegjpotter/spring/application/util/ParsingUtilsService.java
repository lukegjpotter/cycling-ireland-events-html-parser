package com.lukegjpotter.spring.application.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.DayDateTimeModel;
import com.lukegjpotter.spring.application.util.UtilsService;;

@Service
public class ParsingUtilsService {

    @Autowired private UtilsService utils;
    
    /**
     * Parses a string containing the Day, Date and Time into a
     * DayDateTimeModel. The expected format is
     * "DAY, Month Day, Year | 12HourTime" E.G.
     * "Saturday, July 30, 2016 | 8:00am"
     * 
     * @param dayDateTime
     * @return Populated DayDateTimeModel
     */
    public DayDateTimeModel parseDayDateTimeString(String dayDateTime) {

        String[] dayDateTimeStringArray = dayDateTime.split(",", 2);
        String day = dayDateTimeStringArray[0].trim();
        String[] dateAndTimeStringArray = dayDateTimeStringArray[1].split("\\|");
        Date date = utils.convertMMMMDDYYYYToDate(dateAndTimeStringArray[0].trim());
        String time = dateAndTimeStringArray[1].trim();

        return new DayDateTimeModel(day, date, time);
    }
}
