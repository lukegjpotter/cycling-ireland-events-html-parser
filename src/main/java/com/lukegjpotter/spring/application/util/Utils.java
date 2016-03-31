package com.lukegjpotter.spring.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * Converts the Date String to a Date Object. The format is "July 30, 2016".
     * 
     * @param startDate
     *            String of the format "MonthName Day, Year".
     * @return The Date Object for the startDate.
     */
    public static Date convertStringToDate(String startDate) {
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT).parse(startDate);
        } catch (ParseException e) {
            return null;
        }
    }
}
