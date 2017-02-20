package com.lukegjpotter.spring.application.util;

import org.springframework.stereotype.Service;

@Service
public class NullCheckUtilsService {

    public String timeNullCheck(String time) {
        return stringNullCheck(time.trim().replace(".", ":"));
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
            return new Double(0);
        }
    }
    
    public Integer integerNullCheck(String string) {
        try {
            return Integer.parseInt(string.trim());
        } catch (NumberFormatException e) {
            return new Integer(0);
        }
    }
}
