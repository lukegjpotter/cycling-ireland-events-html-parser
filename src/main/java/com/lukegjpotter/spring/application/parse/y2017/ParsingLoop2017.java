package com.lukegjpotter.spring.application.parse.y2017;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.service.UrlMonthService;
import com.lukegjpotter.spring.application.util.Constants;

@Service
public class ParsingLoop2017 implements ParsingLoop {
    
    @Autowired UrlMonthService urlMonthSerivce;
    @Autowired BasicDetailsParser basicDetailsParser;
    @Autowired PopupDetailsParser popupDetailsParser;
    @Autowired StageDetailsParser stageDetailsParser;
    
    private boolean isRemote;
    
    @Override public List<RoadRaceEvent> startParseLoop(String fileLocation) {

        List<RoadRaceEvent> roadRaceEvents = new ArrayList<>();
        Element document = null;
        List<String> urls = urlMonthSerivce.compileUrlsForRemainYearMonths();
        isRemote = fileLocation.isEmpty();
        
        for (String url : urls) {
            
            try {
                if (isRemote) {
                    document = Jsoup.connect(url).get();
                } else {
                    document = Jsoup.parse(new File("src/test/resources/201702RoadEvents.html"), Constants.FILE_FORMAT);
                }
            } catch (IOException e) { e.printStackTrace(); }
            
            Elements allAnchors = document.getElementsByClass("cat163473");
            
            for (Element event : allAnchors) {
                RoadRaceEvent roadRace = new RoadRaceEvent();
                
                // Get Basic Details; ID and Name.
                roadRace = basicDetailsParser.parse(event);
                
                // Get Popup Details; Date, Province, Category, Promoting Club, Contact Person, More Info.
                Element popupElement = makePopupDetailsElementFromRoadRaceId(roadRace.getId());
                PopupDetails popupDetails = popupDetailsParser.parse(popupElement);
                roadRace.addPopupDetails(popupDetails);
                
                // Get More Information Link Details AKA StageDetails.
                Element stageDetailsElement = makeStageDetailsElementFromMoreInfoUrl(popupDetails.getMoreInfoUrl());
                List<StageDetail> stageDetails = stageDetailsParser.parse(stageDetailsElement);
                roadRace.setStageDetails(stageDetails);
                
                roadRaceEvents.add(roadRace);
            }
        }

        return roadRaceEvents;
    }

    private Element makePopupDetailsElementFromRoadRaceId(long eventId) {
        
        File popupHtmlFile = new File("src/test/resources/20170225-Popup-DWCCOpenRace.html");

        try {
            // TODO Use the URL instead of the File for Production.
            return Jsoup.parse(popupHtmlFile, Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
    
    private Element makeStageDetailsElementFromMoreInfoUrl(URL moreInfoUrl) {
        
        File stageDetailsHtmlFile = new File("src/test/resources/20170225-Stages-DWCCOpenRace.html");

        try {
            // TODO Use the URL instead of the File for Production.
            return Jsoup.parse(stageDetailsHtmlFile, Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
}
