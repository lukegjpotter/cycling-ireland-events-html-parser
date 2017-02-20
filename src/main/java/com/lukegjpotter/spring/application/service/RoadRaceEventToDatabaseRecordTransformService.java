package com.lukegjpotter.spring.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.util.UtilsService;

/**
 * {@code RoadRaceEventToDatabaseRecordTransformService} transforms the
 * {@code RoadRaceEvent} pojos into {@code RoadRaceEventDatabaseRecord} pojos.
 * This will make writing, and reading with other services, to the Database via
 * Spring Data easier.
 * 
 * @author lukegjpotter
 */
@Service public class RoadRaceEventToDatabaseRecordTransformService {

    @Autowired StageDetailsRaceTypesService raceTypeService;
    @Autowired UtilsService utils;
    
    public List<RoadRaceEventDatabaseRecord> transform(List<RoadRaceEvent> roadRaces) {
        
        List<RoadRaceEventDatabaseRecord> databaseRecords = new ArrayList<>();
        
        roadRaces.forEach(roadRace -> {
            RoadRaceEventDatabaseRecord databaseRecord = new RoadRaceEventDatabaseRecord();
            
            databaseRecord.setBookingsCloseDate(roadRace.getBookingsCloseDate());
            databaseRecord.setBookingsOpenDate(roadRace.getBookingsOpenDate());
            databaseRecord.setEventName(roadRace.getEventName());
            databaseRecord.setLocation(roadRace.getLocation());
            databaseRecord.setOrganiser(roadRace.getOrganiser());
            databaseRecord.setOrganiserEmail(roadRace.getOrganiserEmail());
            databaseRecord.setOrganiserPhoneNumber(roadRace.getOrganiserPhoneNumber());
            databaseRecord.setPromotingClub(roadRace.getPromotingClub());
            databaseRecord.setProvince(roadRace.getProvince());
            databaseRecord.setRegistrationLink(roadRace.getRegistrationLink());
            databaseRecord.setStageDetails(roadRace.getStageDetails());
            databaseRecord.setStartDate(roadRace.getStartDate());
            databaseRecord.setMonthNumber(utils.extractMonthNumberFromDate(roadRace.getStartDate()));
            
            RaceTypesHolder raceTypes = raceTypeService.determineRaceTypes(roadRace.getStageDetails());
            databaseRecord.addRaceTypes(raceTypes);
            
            databaseRecords.add(databaseRecord);
        });
        
        return databaseRecords;
    }

}
