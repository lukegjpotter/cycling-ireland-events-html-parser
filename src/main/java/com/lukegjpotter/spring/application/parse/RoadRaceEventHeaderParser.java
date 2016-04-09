package com.lukegjpotter.spring.application.parse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
public class RoadRaceEventHeaderParser {
    
    @Autowired UtilsService utils;

    public RoadRaceEvent parse(String htmlNodeToParse) {
        
        RoadRaceEvent race = new RoadRaceEvent();
        race.setStartDate(utils.convertDDMMMYYToDate("03-Apr-16"));
        race.setEventName("Dungarvan Open Race");
        race.setPromotingClub("Dungarvan CC");
        race.setOrganiser("John Coleman");
        race.setRegisterationLink(""); // TODO Parse this from CI Website.
        race.setBookingsOpenDate(utils.convertDDMMYYYYToDate("03/04/2016"));
        race.setBookingsCloseDate(utils.convertDDMMYYYYToDate("03/04/2016"));
        race.setOrganiserPhoneNumber("+353858500404");
        race.setOrganiserEmail("john.coleman@mts.ie");
        race.setLocation("Soccer Club, Dungarvan");
        race.setProvince("Munster");
        
        return race;
    }
}
