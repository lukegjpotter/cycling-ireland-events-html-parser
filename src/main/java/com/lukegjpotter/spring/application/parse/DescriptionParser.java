package com.lukegjpotter.spring.application.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.Description;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
public class DescriptionParser implements Parsable<Description> {

    @Autowired UtilsService utils;
    
    @Override public Description parse(String htmlToParse) {
        
        Description description = new Description();
        
        Element body = Jsoup.parseBodyFragment(htmlToParse).body();
        Elements tableData = body.getElementsByClass("tdvalueItem");
        
        description.setBookingsOpenDate(utils.convertDDMMYYYYToDate(tableData.get(0).text().trim()));
        description.setBookingsCloseDate(utils.convertDDMMYYYYToDate(tableData.get(1).text().trim()));
        description.setOrganiserPhoneNumber(formatPhoneNumber(tableData.get(2).text().trim().replace(" ", "")));
        description.setOrganiserEmail(tableData.get(3).text().trim());
        description.setLocation(formatLocation(tableData.get(4).text().trim()));
        description.setProvince("Munster");
        
        return description;
    }

    private String formatLocation(String location) {
        
        if (((Character)location.charAt(0)).equals(',')) {
            int i;
            for (i = 1; !Character.isLetter(location.charAt(i)); i++) ;
                
            return location.substring(i);
        }
        
        return location;
    }

    private String formatPhoneNumber(String phoneNumber) {
        
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
