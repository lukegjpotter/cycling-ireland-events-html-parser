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
    
    @Override public List<RoadRaceEvent> startParseLoop(String fileLocation) {

        List<RoadRaceEvent> roadRaceEvents = new ArrayList<>();

        fileLocation = "src/main/resources/201702RoadEvents.html";
        htmlFile = new File(fileLocation);

        Element document = null;

        try {
            document = Jsoup.parse(htmlFile, Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }

        RoadRaceEvent roadRace = new RoadRaceEvent();
        
        Elements allAnchors = document.getElementsByClass("cat163473");

        for (Element event : allAnchors) {
            
            // Get Basic Details, ID and Name.
            roadRace = basicDetailsParser.parse(event);
            // Get Popup Details.
            // Get Mode Information Link Details AKA StageDetails.
        }

        roadRaceEvents.add(roadRace);
        
        return roadRaceEvents;
    }

}
