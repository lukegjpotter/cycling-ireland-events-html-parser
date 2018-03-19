package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MappingHolderToStageDetailsService {

    private final Logger LOG = Logger.getLogger(MappingHolderToStageDetailsService.class.getName());
    private boolean isMissingRoutes = false;

    /**
     * @param mappingHolder
     * @param roadRaces
     * @return {@code roadRaces} with its {@code StageDetail} elements containing links to the routes, determined from the CSV file.
     */
    public List<RoadRaceEvent> mapStageDetails(StageRouteMappingHolder mappingHolder, List<RoadRaceEvent> roadRaces) {

        StringBuilder missingRoutesStringBuilder = new StringBuilder("Events missing from AllRouteLinks.csv are:\n");

        roadRaces.forEach(roadRace -> {
            roadRace.getStageDetails().forEach(stageDetail -> {
                try {
                    stageDetail.setRouteLinkUrl(mappingHolder.getRouteUrlMapping(roadRace.getId(), stageDetail.getStageNumber()));
                } catch (NullPointerException e) {
                    isMissingRoutes = true;
                    missingRoutesStringBuilder.append(roadRace.getEventName())
                        .append(",")
                        .append(roadRace.getId())
                        .append(",").append("\n");
                }
            });
            LOG.fine("Adding Routes for: " + roadRace.getEventName());
        });
        
        if (isMissingRoutes)
            LOG.warning(missingRoutesStringBuilder.toString());
        
        return roadRaces;
    }
}
