package com.lukegjpotter.spring.application.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
public class RoadRaceEventHeaderParser {
    
    @Autowired UtilsService utils;

    public RoadRaceEvent parse(String htmlNodeToParse) {
        
        RoadRaceEvent race = new RoadRaceEvent();
        
        Element roadRaceHeader = Jsoup.parseBodyFragment(htmlNodeToParse).body();
        Elements tableData = roadRaceHeader.select("span");
        
        String startDate = tableData.first().text().trim();
        race.setStartDate(utils.convertDDMMMYYToDate(startDate));
        
        race.setEventName("Dungarvan Open Race");
        race.setPromotingClub("Dungarvan CC");
        race.setOrganiser("John Coleman");
        
        race.setOrganiserPhoneNumber("+353858500404");
        race.setOrganiserEmail("john.coleman@mts.ie");
        race.setLocation("Soccer Club, Dungarvan");
        
        race.setRegisterationLink(""); // TODO Parse this from CI Website.
        race.setBookingsOpenDate(utils.convertDDMMYYYYToDate("03/04/2016"));
        race.setBookingsCloseDate(utils.convertDDMMYYYYToDate("03/04/2016"));
        race.setProvince("Munster");
        
        return race;
    }
}
