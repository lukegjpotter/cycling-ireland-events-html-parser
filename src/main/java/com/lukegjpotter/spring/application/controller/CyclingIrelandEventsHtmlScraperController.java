package com.lukegjpotter.spring.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.service.HtmlParsingService;

@RestController
public class CyclingIrelandEventsHtmlScraperController {

    @Autowired private HtmlParsingService htmlParsingService;
    private List<RoadRaceEvent> roadRaces;
    
    @RequestMapping("/start") public void start() {
        extract();
        transform();
        load();
        
    }

    private void extract() {
        roadRaces = htmlParsingService.parse();
    }
    
    private void transform() {
        // TODO Transform RoadRaceEvents into RoadRaceEventDatabaseRecords.
    }
    
    private void load() {
        roadRaces.forEach(roadRace -> System.out.println(roadRace.toString()));
    }
    
}
