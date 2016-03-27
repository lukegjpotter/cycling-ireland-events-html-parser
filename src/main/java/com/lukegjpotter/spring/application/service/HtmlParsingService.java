package com.lukegjpotter.spring.application.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.lukegjpotter.spring.application.model.DayDateTimeModel;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.util.ParsingUtils;

@Service
public class HtmlParsingService {
    
    private static final Logger log = Logger.getLogger(HtmlParsingService.class.getName());

    private String pageOneLocation, pageTwoLocation;

    public RoadRaceEvent parsePageOne() {
        
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        try {
            Document pageOne = Jsoup.parse(new File(pageOneLocation), "utf-8");
            
            // Event Title
            Element eventTitleElement = pageOne.getElementById("event_title");
            roadRaceEvent.setEventName(eventTitleElement.child(0).text().trim());
            
            // Day, Start Date, Sign On Time
            Element eventDateTimeElement = pageOne.getElementById("event_date");
            DayDateTimeModel dayDateTime = ParsingUtils.parseDayDateTimeString(eventDateTimeElement.child(0).text().trim());
            roadRaceEvent.setStartDay(dayDateTime.getDay());
            roadRaceEvent.setStartDate(dayDateTime.getDate());
            roadRaceEvent.setSignOnTime(dayDateTime.getTime());
            
            // Province
            String province = pageOne.getElementById("event_details").select("a").first().text().trim();
            roadRaceEvent.setProvince(province);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return roadRaceEvent;
    }

    public RoadRaceEvent parsePageTwo() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setPageOneLocation(String pageOneLocation) {
        this.pageOneLocation = pageOneLocation;
    }

    public void setPageTwoLocation(String pageTwoLocation) {
        this.pageTwoLocation = pageTwoLocation;
    }
}
