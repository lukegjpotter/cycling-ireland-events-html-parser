package com.lukegjpotter.spring.application.parse.y2016;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.Parsable;
import com.lukegjpotter.spring.application.util.NullCheckUtilsService;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
class HeaderParser implements Parsable<String, RoadRaceEvent> {
    
    @Autowired UtilsService utils;
    @Autowired NullCheckUtilsService nullCheckUtils;

    @Override public RoadRaceEvent parse(String htmlToParse) {
        
        RoadRaceEvent race = new RoadRaceEvent();
        
        Element roadRaceHeader = Jsoup.parseBodyFragment(htmlToParse).body();
        
        Elements tableData = roadRaceHeader.select("span");
        race.setStartDate(utils.convertDDMMMYYToDate(tableData.first().text()));
        
        tableData = roadRaceHeader.getElementsByTag("div");
        race.setEventName(nullCheckUtils.stringNullCheck(tableData.get(0).text()));
        race.setPromotingClub(nullCheckUtils.stringNullCheck(tableData.get(1).text()));
        race.setOrganiser(nullCheckUtils.stringNullCheck(tableData.get(2).text()));
        
        race.setRegistrationLink(""); // TODO Parse this from CI Website.
        
        return race;
    }
}
