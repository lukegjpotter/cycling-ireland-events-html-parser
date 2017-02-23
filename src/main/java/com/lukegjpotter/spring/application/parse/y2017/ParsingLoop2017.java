package com.lukegjpotter.spring.application.parse.y2017;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.util.Constants;

@Service
public class ParsingLoop2017 implements ParsingLoop {

    private File htmlFile;
    
    @Autowired BasicDetailsParser basicDetailsParser;
    @Autowired PopupDetailsParser popupDetailsParser;
    
    @Override public List<RoadRaceEvent> startParseLoop(String fileLocation) {

        List<RoadRaceEvent> roadRaceEvents = new ArrayList<>();

        // TODO Change this file location to a URL for production.
        fileLocation = "src/main/resources/201702RoadEvents.html";
        htmlFile = new File(fileLocation);

        Element document = null;

        try {
            document = Jsoup.parse(htmlFile, Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        Elements allAnchors = document.getElementsByClass("cat163473");
        RoadRaceEvent roadRace = new RoadRaceEvent();

        for (Element event : allAnchors) {
            
            // Get Basic Details; ID and Name.
            roadRace = basicDetailsParser.parse(event);
            
            // Get Popup Details; Date, Province, Category, Promoting Club, Contact Person, More Info.
            Element popupElement = getJsoupElementFromPopup(roadRace.getId());
            roadRace.addPopupDetails(popupDetailsParser.parse(popupElement));
            
            // Get More Information Link Details AKA StageDetails.
        }

        roadRaceEvents.add(roadRace);
        
        return roadRaceEvents;
    }

    private Element getJsoupElementFromPopup(long eventId) {
        
        String popupFileLocation = "src/main/resources/20170225-Popup-DWCCOpenRace.html";
        File popupHtmlFile = new File(popupFileLocation);

        Element document = null;

        try {
            document = Jsoup.parse(popupHtmlFile, Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return document;
    }

}
