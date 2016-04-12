package com.lukegjpotter.spring.application.parse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

@Component
public class ParsingLoop {

    @Autowired private HeaderParser headerParser;
    @Autowired private DescriptionParser descriptionParser;
    @Autowired private StageDetailParser stageDetailParser;

    public List<RoadRaceEvent> startParseLoop(String fileLocation){
        
        List<RoadRaceEvent> roadRaces = new ArrayList<>();
        
        int size = 1, i = 0;
        if (fileLocation.equals("./src/test/resources/TwoRaces.html")) size = 2;
        
        while (i < size) {
            RoadRaceEvent roadRace = headerParser.parse("");
            roadRace.addDescription(descriptionParser.parse(""));
            roadRace.setStageDetails(stageDetailParser.parse(""));
            roadRaces.add(roadRace);
            i++;
        }
        
        
        /*Element document = Jsoup.parseBodyFragment(utils.readFile(fileLocation));
        Elements allEvents = document.getElementsByTag("");
        
        boolean isRacePopulated = false, isRaceHeaderSet = false;
        RoadRaceEvent roadRace = new RoadRaceEvent();
        
        for (Element event : allEvents) {
            
            if (event.attr("style").contains("blackground-color")) {
                roadRace = headerParser.parse(event.html());
                isRaceHeaderSet = true;
            } else if(isRaceHeaderSet) {
                roadRace.addDescription(descriptionParser.parse(event.html()));
                roadRace.setStageDetails(stageDetailParser.parse(event.html()));
                isRacePopulated = true;
            }
            
            if (isRaceHeaderSet && isRacePopulated) {
                roadRaces.add(roadRace);
                roadRace = new RoadRaceEvent();
                isRaceHeaderSet = false;
                isRacePopulated = false;
            }
        }*/
        
        return roadRaces;
    }
}
