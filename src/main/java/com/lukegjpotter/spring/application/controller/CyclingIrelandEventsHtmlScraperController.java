package com.lukegjpotter.spring.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.service.HtmlParsingService;
import com.lukegjpotter.spring.application.service.RoadRaceEventToDatabaseRecordTransformService;

@RestController
public class CyclingIrelandEventsHtmlScraperController {

    @Autowired private HtmlParsingService htmlParsingService;
    @Autowired private RoadRaceEventToDatabaseRecordTransformService transformService;
    
    private List<RoadRaceEvent> roadRaces;
    private List<RoadRaceEventDatabaseRecord> databaseRecords;
    
    @RequestMapping("/start") public List<RoadRaceEventDatabaseRecord> start() {
        extract();
        transform();
        return load();
    }

    private void extract() {
        roadRaces = htmlParsingService.parse();
    }
    
    private void transform() {
        databaseRecords = transformService.transform(roadRaces);
    }
    
    private List<RoadRaceEventDatabaseRecord> load() {
        // TODO load into Database
        return databaseRecords;
    }
    
}
