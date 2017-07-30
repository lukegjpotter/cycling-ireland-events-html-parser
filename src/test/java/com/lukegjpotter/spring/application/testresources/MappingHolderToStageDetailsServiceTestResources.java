package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;

/**
 * This class is to reduce the boilerplate needed to create Road Race Events
 * in the other actual test classes.
 * 
 * @author lukegjpotter
 */
@Component
public class MappingHolderToStageDetailsServiceTestResources {

    @Autowired UtilsService utils;
    @Autowired RoadRaceEventToDatabaseRecordTransformServiceTestResources rrtr;
    
    public List<RoadRaceEvent> getOneDayRaceWithMappedStages() {
        List<RoadRaceEvent> oneDayRaces = new ArrayList<>();
        oneDayRaces.add(rrtr.getOneDayRace());
        oneDayRaces.get(0).setStageDetails(getOneDayRaceMappedStageDetails());
        
        return oneDayRaces;
    }

    private List<StageDetail> getOneDayRaceMappedStageDetails() {
        List<StageDetail> stageDetails = rrtr.getOneDayRaceStageDetails();
        stageDetails.forEach(stageDetail -> {
            stageDetail.setRouteLinkUrl("http://www.strava.com/routes/123456");
        });
        
        return stageDetails;
    }

    public List<RoadRaceEvent> getStageRaceWithMappedStages() {
        List<RoadRaceEvent> stageRaces = new ArrayList<>();
        stageRaces.add(rrtr.getStageRace());
        stageRaces.get(0).setStageDetails(getStageRaceMappedStageDetails());
        
        return stageRaces;
    }

    private List<StageDetail> getStageRaceMappedStageDetails() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("30/07/2016"), "HEARNS HOTEL", 1, 1, "APlus,A1,A2,A3", 120.0, 74.6, "Road", "9:30", "13:00", "http://www.strava.com/routes/111", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), "HEARNS HOTEL", 1, 2, "APlus,A1,A2,A3", 92.0, 57.2, "Road", "9:30", "11:00", "http://www.strava.com/routes/222", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("31/07/2016"), "HEARNS HOTEL", 1, 3, "APlus,A1,A2,A3", 35.0, 21.7, "Criterium", "18:00", "19:00", "http://www.strava.com/routes/333", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("01/08/2016"), "HEARNS HOTEL", 1, 4, "APlus,A1,A2,A3", 122.0, 75.8, "Road", "9:30", "11:00", "http://www.strava.com/routes/444", ""));
        
        return stageDetails;
    }
}
