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
        description.setLocation(tableData.get(4).text().trim());
        description.setProvince("Munster");
        
        return description;
    }

    private String formatPhoneNumber(String phoneNumber) {
        
        if (phoneNumber.startsWith(Prefix.N_IRELAND_IRELAND_ZERO.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_IRELAND_ZERO.code, Prefix.IRELAND.code);
        } else if (phoneNumber.startsWith(Prefix.N_IRELAND_DOUBLE.code)) {
            return phoneNumber.replace(Prefix.N_IRELAND_DOUBLE.code, Prefix.N_IRELAND.code);
        } else if (!phoneNumber.startsWith(Prefix.PLUS.code)) {
            return Prefix.IRELAND + phoneNumber;
        }
        return phoneNumber;
    }
    
    private enum Prefix {
        PLUS("+"), IRELAND("+353"), N_IRELAND("+44"), N_IRELAND_DOUBLE("+44+44"), N_IRELAND_IRELAND_ZERO("+44+3530");
        
        private String code;
        
        private Prefix(String code) {
            this.code = code;
        }
        
        @Override public String toString() {
            return code;
        }
    }

}
