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
        
        Document pageOne = null;
        try {
            pageOne = Jsoup.parse(new File(pageOneLocation), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Element pageOneEventDetails = pageOne.getElementById("event_details");
        String contactIndex = "Contact: ", emailIndex = "Email:", phoneIndex = "Phone:", moreInfoIndex = "More Info:";
        String pageOneEventDetailsText = pageOneEventDetails.text();
          
        // Event Title
        String eventTitle = pageOne.getElementById("event_title").child(0).text().trim();
        roadRaceEvent.setEventName(eventTitle);
        
        // Day, Start Date, Sign On Time
        Element eventDateTimeElement = pageOne.getElementById("event_date");
        DayDateTimeModel dayDateTime = ParsingUtils.parseDayDateTimeString(eventDateTimeElement.child(0).text().trim());
        roadRaceEvent.setStartDay(dayDateTime.getDay());
        roadRaceEvent.setStartDate(dayDateTime.getDate());
        roadRaceEvent.setSignOnTime(dayDateTime.getTime());
        
        // Province
        String province = pageOneEventDetails.select("a").first().text().trim();
        roadRaceEvent.setProvince(province);
        
        // Category
        String category = pageOneEventDetails.getElementById("cw_category_span").getElementsByTag("td").get(1).text().trim();
        roadRaceEvent.setCategory(category);
        
        // Promoting Club
        String promotingClub = pageOneEventDetails.select("div[style=\"word-wrap: break-word\"]").first().text().trim();
        roadRaceEvent.setPromotingClub(promotingClub);
        
        // Primary Contact Person Details
        String primaryContactPerson = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(contactIndex) + contactIndex.length(), pageOneEventDetailsText.indexOf(emailIndex)).trim();
        roadRaceEvent.setPrimaryContactPerson(primaryContactPerson);
        
        // Primary Contact Email
        String primaryContactEmail = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(emailIndex) + emailIndex.length(), pageOneEventDetailsText.indexOf(phoneIndex)).trim();
        roadRaceEvent.setPrimaryContactEmail(primaryContactEmail);
        
        // Primary Contact Person Phone
        String primaryContactPhoneNumber = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(phoneIndex) + phoneIndex.length(), pageOneEventDetailsText.indexOf(moreInfoIndex)).trim();
        roadRaceEvent.setPrimaryContactPhoneNumber(primaryContactPhoneNumber);

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
