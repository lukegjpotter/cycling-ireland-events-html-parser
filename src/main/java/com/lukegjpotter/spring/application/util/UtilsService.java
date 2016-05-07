package com.lukegjpotter.spring.application.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    private Date convertDateUsingFormat(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date.trim());
        } catch (ParseException e) {
            return null;
        }
    }
    
    public boolean isListElementInString(String string, List<String> elements) {
        
        for (String element : elements) {
            if (string.contains(element))
                return true;
        }

        return false;
    }
    
    public String formatLocation(String location) {
        
        location = location.trim();
        int i = 0;
        
        if (!location.isEmpty() && ((Character)location.charAt(i)).equals(',')) {
            
            try {
                for (; !Character.isLetter(location.charAt(i)); ++i) ;
            } catch (StringIndexOutOfBoundsException e) {}
                
            return location.substring(i);
        }
        
        return location;
    }

    public String formatPhoneNumber(String phoneNumber) {
        
        phoneNumber = phoneNumber.trim().replace(" ", "").replace("-", "");
        
        if (phoneNumber.isEmpty()) {
            return phoneNumber;
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_IRELAND_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_IRELAND.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_IRELAND.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_DOUBLE_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_DOUBLE_ZERO.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_DOUBLE.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_DOUBLE.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_DOUBLE_ZERO.code)) {
            return phoneNumber.replace(Prefix.IRELAND_DOUBLE_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_DOUBLE.code)) {
            return phoneNumber.replace(Prefix.IRELAND_DOUBLE.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN.code)) {
            return phoneNumber.replace(Prefix.IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.IRELAND_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_N_IRELAND.code)) {
            return phoneNumber.replace(Prefix.IRELAND_N_IRELAND.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.IRELAND_EXTRA_PLUS.code)) {
            return phoneNumber.replace(Prefix.IRELAND_EXTRA_PLUS.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_ZERO.code, Prefix.N_IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_NO_COUNTRY_CODE.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_NO_COUNTRY_CODE.code, Prefix.N_IRELAND + "7");
        } else if (!phoneNumber.startsWith(Prefix.PLUS.code)) {
            return Prefix.IRELAND + phoneNumber;
        }
        return phoneNumber;
    }
    
    private enum Prefix {
        PLUS("+"), IRELAND("+353"), N_IRELAND("+44"),
        IRELAND_DOUBLE("+353+353"), IRELAND_DOUBLE_ZERO("+353+3530"), IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN("+353353"), IRELAND_ZERO("+3530"), IRELAND_N_IRELAND("+353+44"), IRELAND_EXTRA_PLUS("+353+"),
        N_IRELAND_DOUBLE("+44+44"), N_IRELAND_IRELAND_ZERO("+44+3530"), N_IRELAND_DOUBLE_ZERO("+44+440"), N_IRELAND_ZERO("+440"), N_IRELAND_IRELAND("+44+353"), N_IRELAND_NO_COUNTRY_CODE("07");
        
        private String code;
        
        private Prefix(String code) {
            this.code = code;
        }
        
        @Override public String toString() {
            return code;
        }
    }
}
