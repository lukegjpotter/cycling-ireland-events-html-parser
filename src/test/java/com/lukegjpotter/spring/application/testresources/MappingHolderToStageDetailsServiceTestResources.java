package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to reduce the boilerplate needed to create Road Race Events
 * in the other actual test classes.
 * 
 * @author lukegjpotter
 */
@Component
public class MappingHolderToStageDetailsServiceTestResources {

    @Autowired
    private UtilsService utils;
    @Autowired
    private RoadRaceEventToDatabaseRecordTransformServiceTestResources rrtr;
    
    public List<RoadRaceEvent> getOneDayRaceWithMappedStages() {
        List<RoadRaceEvent> oneDayRaces = new ArrayList<>();
        oneDayRaces.add(rrtr.getOneDayRace());
        oneDayRaces.get(0).setStageDetails(getOneDayRaceMappedStageDetails());
        
        return oneDayRaces;
    }

    private List<StageDetail> getOneDayRaceMappedStageDetails() {
        List<StageDetail> stageDetails = rrtr.getOneDayRaceStageDetails();
        stageDetails.forEach(stageDetail -> stageDetail.setRouteLinkUrl("http://www.strava.com/routes/123456"));
        
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
        StageDetail stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("30 Jul 2016"));
        stageDetail.setVenue("HEARNS HOTEL");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("http://www.strava.com/routes/111");
        stageDetail.setStageName("Stage 1");
        stageDetails.add(stageDetail);

        stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("31 Jul 2016"));
        stageDetail.setVenue("HEARNS HOTEL");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("http://www.strava.com/routes/222");
        stageDetail.setStageName("Stage 2");
        stageDetails.add(stageDetail);

        stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("1 Aug 2016"));
        stageDetail.setVenue("HEARNS HOTEL");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("http://www.strava.com/routes/333");
        stageDetail.setStageName("Stage 3");
        stageDetails.add(stageDetail);

        stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("2 Aug 2016"));
        stageDetail.setVenue("HEARNS HOTEL");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setCategory("A1,A2,A3");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("http://www.strava.com/routes/444");
        stageDetail.setStageName("Stage 4");
        stageDetails.add(stageDetail);

        return stageDetails;
    }
}
