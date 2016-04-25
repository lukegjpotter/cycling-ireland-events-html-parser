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
    
    public String formatLocation(String location) {
        
        if (((Character)location.charAt(0)).equals(',')) {
            int i;
            for (i = 1; !Character.isLetter(location.charAt(i)); i++) ;
                
            return location.substring(i);
        }
        
        return location;
    }

    public String formatPhoneNumber(String phoneNumber) {
        
        if (phoneNumber.startsWith(Prefix.N_IRELAND_IRELAND_ZERO.code)) {
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
        } else if (!phoneNumber.startsWith(Prefix.PLUS.code)) {
            return Prefix.IRELAND + phoneNumber;
        }
        return phoneNumber;
    }
    
    private enum Prefix {
        PLUS("+"), IRELAND("+353"), N_IRELAND("+44"),
        IRELAND_DOUBLE("+353+353"), IRELAND_DOUBLE_ZERO("+353+3530"), IRELAND_DOUBLE_NO_SECOND_PLUS_SIGN("+353353"), IRELAND_ZERO("+3530"), IRELAND_N_IRELAND("+353+44"), IRELAND_EXTRA_PLUS("+353+"),
        N_IRELAND_DOUBLE("+44+44"), N_IRELAND_IRELAND_ZERO("+44+3530"), N_IRELAND_DOUBLE_ZERO("+44+440"), N_IRELAND_ZERO("+440"), N_IRELAND_IRELAND("+44+353");
        
        private String code;
        
        private Prefix(String code) {
            this.code = code;
        }
        
        @Override public String toString() {
            return code;
        }
    }
}
