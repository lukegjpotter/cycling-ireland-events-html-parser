package com.lukegjpotter.spring.application.parse.y2016;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.Description;
import com.lukegjpotter.spring.application.parse.Parsable;
import com.lukegjpotter.spring.application.util.NullCheckUtilsService;
import com.lukegjpotter.spring.application.util.PhoneNumberUtilsService;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
class DescriptionParser implements Parsable<String, Description> {

    @Autowired UtilsService utils;
    @Autowired NullCheckUtilsService nullCheckUtils;
    @Autowired PhoneNumberUtilsService phoneNumberUtils;
    
    @Override public Description parse(String htmlToParse) {
        
        Description description = new Description();
        
        Element body = Jsoup.parseBodyFragment(htmlToParse).body();
        Elements tableData = body.getElementsByClass("tdvalueItem");
        
        description.setBookingsOpenDate(utils.convertDDMMYYYYToDate(tableData.get(0).text()));
        description.setBookingsCloseDate(utils.convertDDMMYYYYToDate(tableData.get(1).text()));
        description.setOrganiserPhoneNumber(phoneNumberUtils.formatPhoneNumber(tableData.get(2).text()));
        description.setOrganiserEmail(nullCheckUtils.stringNullCheck(tableData.get(3).text()));
        description.setLocation(utils.formatLocation(tableData.get(4).text()));
        //description.setProvince("Munster"); // TODO Source Province from somewhere, maybe CSV file.
                
        return description;
    }

}
