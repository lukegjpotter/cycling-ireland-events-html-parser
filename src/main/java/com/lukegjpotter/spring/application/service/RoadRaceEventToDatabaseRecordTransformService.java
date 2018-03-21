package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * {@code RoadRaceEventToDatabaseRecordTransformService} transforms the
 * {@code RoadRaceEvent} pojos into {@code RoadRaceEventDatabaseRecord} pojos.
 * This will make writing, and reading with other services, to the Database via
 * Spring Data easier.
 * 
 * @author lukegjpotter
 */
@Service
public class RoadRaceEventToDatabaseRecordTransformService {

    @Autowired
    private StageDetailsRaceTypesService raceTypeService;
    @Autowired
    private UtilsService utils;

    public List<RoadRaceEventDatabaseRecord> transform(List<RoadRaceEvent> roadRaces) {
        
        List<RoadRaceEventDatabaseRecord> databaseRecords = new ArrayList<>();

        roadRaces.forEach(roadRaceEvent -> {
            RoadRaceEventDatabaseRecord databaseRecord = new RoadRaceEventDatabaseRecord();

            databaseRecord.setId(roadRaceEvent.getId());
            databaseRecord.setBookingsCloseDate(roadRaceEvent.getBookingsCloseDate());
            databaseRecord.setBookingsOpenDate(roadRaceEvent.getBookingsOpenDate());
            databaseRecord.setEventName(roadRaceEvent.getEventName());
            databaseRecord.setLocation(roadRaceEvent.getLocation());
            databaseRecord.setOrganiser(roadRaceEvent.getOrganiser());
            databaseRecord.setOrganiserEmail(roadRaceEvent.getOrganiserEmail());
            databaseRecord.setOrganiserPhoneNumber(roadRaceEvent.getOrganiserPhoneNumber());
            databaseRecord.setPromotingClub(roadRaceEvent.getPromotingClub());
            databaseRecord.setProvince(roadRaceEvent.getProvince());
            databaseRecord.setRegistrationLink(roadRaceEvent.getRegistrationLink());
            databaseRecord.setStageDetails(roadRaceEvent.getStageDetails());
            databaseRecord.setStartDate(roadRaceEvent.getStartDate());
            databaseRecord.setMonthNumber(utils.extractMonthNumberFromDate(roadRaceEvent.getStartDate()));

            RaceTypesHolder raceTypes = raceTypeService.determineRaceTypes(roadRaceEvent.getStageDetails());
            databaseRecord.addRaceTypes(raceTypes);
            
            databaseRecords.add(databaseRecord);
        });
        
        return databaseRecords;
    }
}
