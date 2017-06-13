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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.service.UrlMonthService;
import com.lukegjpotter.spring.application.util.Constants;

@Service
public class ParsingLoop2017 implements ParsingLoop {
    
    @Autowired UrlMonthService urlMonthSerivce;
    @Autowired BasicDetailsParser basicDetailsParser;
    @Autowired PopupDetailsParser popupDetailsParser;
    @Autowired StageDetailsParser stageDetailsParser;
    
    @Value("${url.popup}") private String urlPopupWithPlaceholder;
    private String fileLocation;
    
    private boolean isRemote;
    
    @Override public List<RoadRaceEvent> startParseLoop(String fileLocation) {

        List<RoadRaceEvent> roadRaceEvents = new ArrayList<>();
        this.fileLocation = fileLocation;
        isRemote = fileLocation.isEmpty();
        
        List<Element> documents = populateListOfElements();
        
        for (Element document : documents) {
            
            Elements allAnchors = document.getElementsByClass("cat163473");
            
            for (Element event : allAnchors) {
                
                // Get Basic Details; ID and Name.
                RoadRaceEvent roadRace = basicDetailsParser.parse(event);
                
                // Get Popup Details; Date, Province, Category, Promoting Club, Contact Person, More Info.
                Element popupElement = makePopupDetailsElementFromRoadRaceId(roadRace.getId());
                PopupDetails popupDetails = popupDetailsParser.parse(popupElement);
                roadRace.addPopupDetails(popupDetails);
                
                // Get More Information Link Details AKA StageDetails.
                Element stageDetailsElement = makeStageDetailsElementFromMoreInfoUrl(popupDetails.getMoreInfoUrl());
                roadRace.setStageDetails(stageDetailsParser.parse(stageDetailsElement));
                roadRace.setLocation(roadRace.getStageDetails().get(0).getLocation());
                
                roadRaceEvents.add(roadRace);
            }
        }

        return roadRaceEvents;
    }

    private Element makePopupDetailsElementFromRoadRaceId(long eventId) {

        try {
            if (isRemote) {
                return Jsoup.connect(String.format(urlPopupWithPlaceholder, eventId)).get();
            }
            return Jsoup.parse(new File("src/test/resources/20170225-Popup-DWCCOpenRace.html"), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
    
    private Element makeStageDetailsElementFromMoreInfoUrl(URL moreInfoUrl) {
        
        try {
            if (isRemote) {
                return Jsoup.connect(moreInfoUrl.toString()).get();
            }
            return Jsoup.parse(new File("src/test/resources/20170225-Stages-DWCCOpenRace.html"), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
    
    private List<Element> populateListOfElements() {
        
        List<Element> documents = new ArrayList<>();
        
        if (isRemote) {
            // Populate the list of Documents with Remote URLs.
            List<String> urls = urlMonthSerivce.compileUrlsForRemainYearMonths();
            
            for (String url : urls) {
                
                Element remoteDocument = null;
                
                try {
                    remoteDocument = Jsoup.connect(url).get();
                    documents.add(remoteDocument);
                } catch (IOException e) { e.printStackTrace(); }
            }
        } else {
            // Populate the list of Documents with the file path.
            Element localDocument = null;
            
            try {
                localDocument = Jsoup.parse(new File(fileLocation), Constants.FILE_FORMAT);
                documents.add(localDocument);
            } catch (IOException e) { e.printStackTrace(); }
        }

        return documents;
    }
}
