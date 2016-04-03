package com.lukegjpotter.spring.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * Converts the Date String to a Date Object. The format is "July 30, 2016".
     * 
     * @param date
     *            String of the format "MonthName Day, Year".
     * @return The Date Object for the startDate.
     */
    public static Date convertStringToDate(String date) {
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Converts the Date String to a Date Object via the specified format.
     * @param date
     * @param dateFormat
     * @return
     */
    public static Date convertStringToDate(String date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
