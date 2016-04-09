package com.lukegjpotter.spring.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilsService {

    public Date convertMMMMDDYYYYToDate(String date) {
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT_MMMM_DD_YYYY).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public Date convertDDMMMYYToDate(String date) {
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT_DD_MMM_YY).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public Date convertDDMMYYYYToDate(String date) {
        try {
            return new SimpleDateFormat(Constants.DATE_FORMAT_DD_MM_YYYY).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
