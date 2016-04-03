package com.lukegjpotter.spring.application.parse;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.lukegjpotter.spring.application.model.DayDateTimeModel;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.ParsingUtils;

public class PageOneParser implements Parser {

    private String pageLocation;
    
    public PageOneParser(String pageLocation) {
        setPageLocation(pageLocation);
    }

    @Override
    public RoadRaceEvent parse() {
        
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        
        Document pageOne = null;
        try {
            pageOne = Jsoup.parse(new File(pageLocation), Constants.FILE_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String eventDetailsJSoup = "event_details", eventTitleJSoup = "event_title",eventDateJSoup = "event_date", categoryJSoup = "cw_category_span", promotingClubJSoup = "div[style=\"word-wrap: break-word\"]", spaceJSoup = " ", commaSpaceJSoup = ", ";
        String achorTag = "a", tdTag = "td";
        String contactIndex = "Contact: ", emailIndex = "Email:", phoneIndex = "Phone:", moreInfoIndex = "More Info:", locationDetailsIndex = "Location Details";
        
        Element pageOneEventDetails = pageOne.getElementById(eventDetailsJSoup);
        String pageOneEventDetailsText = pageOneEventDetails.text();
          
        // Event Title
        String eventTitle = pageOne.getElementById(eventTitleJSoup).child(0).text().trim();
        roadRaceEvent.setEventName(eventTitle);
        
        // Day, Start Date, Sign On Time
        Element eventDateTimeElement = pageOne.getElementById(eventDateJSoup);
        DayDateTimeModel dayDateTime = ParsingUtils.parseDayDateTimeString(eventDateTimeElement.child(0).text().trim());
        //roadRaceEvent.setStartDay(dayDateTime.getDay());
        roadRaceEvent.setStartDate(dayDateTime.getDate());
        //roadRaceEvent.setSignOnTime(dayDateTime.getTime());
        
        // Province
        String province = pageOneEventDetails.select(achorTag).first().text().trim();
        roadRaceEvent.setProvince(province);
        
        // Category
        String category = pageOneEventDetails.getElementById(categoryJSoup).getElementsByTag(tdTag).get(1).text().trim();
        //roadRaceEvent.setCategory(category);
        
        // Promoting Club
        String promotingClub = pageOneEventDetails.select(promotingClubJSoup).first().text().trim();
        roadRaceEvent.setPromotingClub(promotingClub);
        
        // Primary Contact Person Details
        String primaryContactPerson = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(contactIndex) + contactIndex.length(), pageOneEventDetailsText.indexOf(emailIndex)).trim();
        //roadRaceEvent.setPrimaryContactPerson(primaryContactPerson);
        
        // Primary Contact Email
        String primaryContactEmail = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(emailIndex) + emailIndex.length(), pageOneEventDetailsText.indexOf(phoneIndex)).trim();
        //roadRaceEvent.setPrimaryContactEmail(primaryContactEmail);
        
        // Primary Contact Person Phone
        String primaryContactPhoneNumber = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(phoneIndex) + phoneIndex.length(), pageOneEventDetailsText.indexOf(moreInfoIndex)).trim();
        //roadRaceEvent.setPrimaryContactPhoneNumber(primaryContactPhoneNumber);
        
        // More Info URL
        String moreInfoUrl = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(moreInfoIndex) + moreInfoIndex.length(), pageOneEventDetailsText.indexOf(locationDetailsIndex)).trim();
        //.setMoreInfoUrl(moreInfoUrl);
        
        // Location Details
        String locationDetails = pageOneEventDetailsText.substring(pageOneEventDetailsText.indexOf(locationDetailsIndex) + locationDetailsIndex.length()).trim();
        int lastSpaceIndex = locationDetails.lastIndexOf(spaceJSoup);
        locationDetails = new StringBuilder(locationDetails).replace(lastSpaceIndex, ++lastSpaceIndex, commaSpaceJSoup).toString();
        //roadRaceEvent.setLocationDetails(locationDetails);
        
        return roadRaceEvent;
    }

    public void setPageLocation(String pageLocation) {
        this.pageLocation = pageLocation;
    }

}
