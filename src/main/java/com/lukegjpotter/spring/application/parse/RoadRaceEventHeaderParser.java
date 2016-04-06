package com.lukegjpotter.spring.application.parse;

import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.Utils;

@Component
public class RoadRaceEventHeaderParser {

    public RoadRaceEvent parse(String htmlNodeToParse) {
        
        RoadRaceEvent race = new RoadRaceEvent();
        race.setStartDate(Utils.convertStringToDate("03-Apr-16", Constants.DATE_FORMAT_DD_MMM_YY));
        race.setEventName("Dungarvan Open Race");
        race.setPromotingClub("Dungarvan CC");
        race.setOrganiser("John Coleman");
        race.setRegisterationLink(""); // TODO Parse this from CI Website.
        race.setBookingsOpenDate(Utils.convertStringToDate("03/04/2016", Constants.DATE_FORMAT_DDMMYYYY));
        race.setBookingsCloseDate(Utils.convertStringToDate("03/04/2016", Constants.DATE_FORMAT_DDMMYYYY));
        race.setOrganiserPhoneNumber("+353858500404");
        race.setOrganiserEmail("john.coleman@mts.ie");
        race.setLocation("Soccer Club, Dungarvan");
        race.setProvince("Munster");
        
        return race;
    }
}
