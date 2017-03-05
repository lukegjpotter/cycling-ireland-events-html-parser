package com.lukegjpotter.spring.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.repository.RoadRaceEventDatabaseRecordRepository;
import com.lukegjpotter.spring.application.service.HtmlParsingService;
import com.lukegjpotter.spring.application.service.RoadRaceEventToDatabaseRecordTransformService;

@RestController
public class CyclingIrelandEventsHtmlScraperController {

    @Autowired private HtmlParsingService htmlParsingService;
    // @Autowired private StageDetailsCsvReaderService csvReaderService;
    // @Autowired private MappingHolderToStageDetailsService stageDetailsMappingService;
    @Autowired private RoadRaceEventToDatabaseRecordTransformService transformService;
    @Autowired private RoadRaceEventDatabaseRecordRepository repository;
    
    private List<RoadRaceEvent> roadRaces;
    private List<RoadRaceEventDatabaseRecord> databaseRecords;
    // private StageRouteMappingHolder mappingHolder;
    
    @RequestMapping("/start") public String start() {
        extract();
        transform();
        return load();
    }

    private void extract() {
        roadRaces = htmlParsingService.parse();
        // mappingHolder = csvReaderService.readStageRouteFromCsvFile();
    }
    
    private void transform() {
        // roadRaces = stageDetailsMappingService.mapStageDetails(mappingHolder, roadRaces);
        databaseRecords = transformService.transform(roadRaces);
    }
    
    private String load() {
        repository.save(databaseRecords);
        return "Success";
    }
    
}
