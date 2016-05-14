package com.lukegjpotter.spring.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;

@Service
public class MappingHolderToStageDetailsService {

    /**
     * @param mappingHolder
     * @param roadRaces
     * @return {@code roadRaces} with its {@code StageDetail} elements containing links to the routes, determined from the CSV file.
     */
    public List<RoadRaceEvent> mapStageDetails(StageRouteMappingHolder mappingHolder, List<RoadRaceEvent> roadRaces) {
        
        for (RoadRaceEvent roadRace : roadRaces) {
            String eventName = roadRace.getEventName();
            Date startDate = roadRace.getStartDate();
            
            for (StageDetail stageDetail : roadRace.getStageDetails()) {
                stageDetail.setRouteLinkUrl(mappingHolder.getRouteUrlMapping(eventName, startDate, stageDetail.getStageNumber()));
            }
        }
        
        return roadRaces;
    }

}
