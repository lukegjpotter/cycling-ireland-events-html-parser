package com.lukegjpotter.spring.application.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilsService {

    public Date convertMMMMDDYYYYToDate(String date) {
        return convertDateUsingFormat(date, Constants.DATE_FORMAT_MMMM_DD_YYYY);
    }

    public Date convertDDMMMYYToDate(String date) {
        return convertDateUsingFormat(date, Constants.DATE_FORMAT_DD_MMM_YY);
    }

    public Date convertDDMMYYYYToDate(String date) {
        return convertDateUsingFormat(date, Constants.DATE_FORMAT_DD_MM_YYYY);
    }

    public Date convertDateUsingFormat(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    
    public String readFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName))).replace("\n", "").replace("\t", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
