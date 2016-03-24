package com.lukegjpotter.spring.application.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

@Service
public class HtmlParsingService {
    
    private static final Logger log = Logger.getLogger(HtmlParsingService.class.getName());

    private String pageOneLocation, pageTwoLocation;

    public RoadRaceEvent parsePageOne() {
        
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        try {
            Document pageOne = Jsoup.parse(new File(pageOneLocation), "utf-8");
            Element eventTitleElement = pageOne.getElementById("event_title");
            roadRaceEvent.setEventName(eventTitleElement.child(0).text().trim());
            log.info(roadRaceEvent.getEventName());
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
