package com.lukegjpotter.spring.application.util;

import org.springframework.stereotype.Service;

@Service
public class NullCheckUtilsService {

    public String timeNullCheck(String time) {
        time = time.trim().replace(".", ":");

        // If the format is 13:0, add an additional 0 to the time.
        if (time.length() <= 5 && time.length() > 0) {
            String hours = time.split(":")[0];
            String minutes = time.split(":")[1];

            if (hours.length() < 2) hours = "0" + hours;
            if (minutes.length() < 2) minutes += "0";

            time = hours + ":" + minutes;
        }
        return stringNullCheck(time);
    }
    
    public String stringNullCheck(String string) {
        if (string.trim().isEmpty())
            return "";
        
        return string.trim();
    }

    public Double doubleNullCheck(String string) {
        try {
            return Double.parseDouble(string.trim());
        } catch (NumberFormatException e) {
            return (double) 0;
        }
    }
    
    public Integer integerNullCheck(String string) {
        try {
            return Integer.parseInt(string.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
