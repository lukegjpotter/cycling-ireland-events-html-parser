package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class ParsingLoop2017TestResources {

    public PopupDetails getMockPopupDetails() {

        URL moreInfoURL = null;
        try {
            moreInfoURL = new URL("http://more.info/url?id=123");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        PopupDetails popupDetails = new PopupDetails();
        popupDetails.setCategory("road");
        popupDetails.setMoreInfoUrl(moreInfoURL);
        popupDetails.setOrganiserEmail("111@abc.com");
        popupDetails.setOrganiserName("Luke Lukeson");
        popupDetails.setOrganiserPhoneNumber("353831234567");
        popupDetails.setPromotingClub("Wheel Wheelers");
        popupDetails.setProvince("Leinster");
        popupDetails.setStartDate(new Date());

        return popupDetails;
    }

    public List<StageDetail> getMockStageDetails() {
        StageDetail stageDetail = new StageDetail();

        stageDetail.setAdditionalInfo("blah");
        stageDetail.setCategory("A4");
        stageDetail.setDate(new Date());
        stageDetail.setId(123L);
        stageDetail.setKilometers(16D);
        stageDetail.setMiles(10D);
        stageDetail.setLocation("Parish Pump");
        stageDetail.setRaceNumber(1);
        stageDetail.setRaceType("Time Trial");
        stageDetail.setRouteLinkUrl("http://strava.com/route/123");
        stageDetail.setSignOnTime("09:30");
        stageDetail.setStageNumber("1");
        stageDetail.setStartTime("10:30");

        return Collections.singletonList(stageDetail);
    }

    public RoadRaceEvent getMockBasicDetails() {
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        roadRaceEvent.setId(123L);
        roadRaceEvent.setEventName("Connacht A4 2 Day");

        return roadRaceEvent;
    }

    public String mockPopupUrl() {
        return "http://ci.ie/popup/?id=%s";
    }

    public String localPopupFile() {
        return "src/test/resources/20180805-Popup-OldcastleGP.html";
    }

    public String localStagesFile() {
        return "src/test/resources/20180805-Stages-OldcastleGP.html";
    }

    public String localBasicFile() {
        return "src/test/resources/201808-RoadEvents.html";
    }

    public int localBasicFileExpectedSize() {
        return 30;
    }
}
