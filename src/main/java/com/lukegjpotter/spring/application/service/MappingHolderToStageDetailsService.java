package com.lukegjpotter.spring.application.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;

@Service
public class MappingHolderToStageDetailsService {

    final Logger LOG = Logger.getLogger(MappingHolderToStageDetailsService.class.getName());
    
    /**
     * @param mappingHolder
     * @param roadRaces
     * @return {@code roadRaces} with its {@code StageDetail} elements containing links to the routes, determined from the CSV file.
     */
    public List<RoadRaceEvent> mapStageDetails(StageRouteMappingHolder mappingHolder, List<RoadRaceEvent> roadRaces) {
        StringBuilder missingRoutesStringBuilder = new StringBuilder("Events missing from AllRouteLinks.csv are:\n");
        boolean isMissingRoutes = false;
        
        for (RoadRaceEvent roadRace : roadRaces) {
            
            for (StageDetail stageDetail : roadRace.getStageDetails()) {
                try {
                    stageDetail.setRouteLinkUrl(mappingHolder.getRouteUrlMapping(roadRace.getId(), stageDetail.getStageNumber()));
                } catch (NullPointerException e) {
                    isMissingRoutes = true;
                    missingRoutesStringBuilder.append(roadRace.getEventName())
                        .append(",")
                        .append(roadRace.getId())
                        .append(",").append("\n");
                }
            }
            LOG.fine("Adding Routes for: " + roadRace.getEventName());
        }
        
        if (isMissingRoutes)
            LOG.warning(missingRoutesStringBuilder.toString());
        
        return roadRaces;
    }

}
