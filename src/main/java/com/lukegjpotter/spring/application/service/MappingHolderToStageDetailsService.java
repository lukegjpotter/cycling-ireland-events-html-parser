package com.lukegjpotter.spring.application.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.util.Constants;

@Service
public class MappingHolderToStageDetailsService {

    final Logger LOG = Logger.getLogger(MappingHolderToStageDetailsService.class.getName());
    
    /**
     * @param mappingHolder
     * @param roadRaces
     * @return {@code roadRaces} with its {@code StageDetail} elements containing links to the routes, determined from the CSV file.
     */
    public List<RoadRaceEvent> mapStageDetails(StageRouteMappingHolder mappingHolder, List<RoadRaceEvent> roadRaces) {
        StringBuilder sb = new StringBuilder("Events missing from AllRouteLinks.csv are:\n");
        
        for (RoadRaceEvent roadRace : roadRaces) {
            String eventName = roadRace.getEventName();
            Date startDate = roadRace.getStartDate();
            
            for (StageDetail stageDetail : roadRace.getStageDetails()) {
                try {
                    stageDetail.setRouteLinkUrl(mappingHolder.getRouteUrlMapping(eventName, startDate, stageDetail.getStageNumber()));
                } catch (NullPointerException e) {
                    sb.append(eventName)
                        .append(",")
                        .append(new SimpleDateFormat(Constants.DATE_FORMAT_DD_MM_YYYY).format(startDate))
                        .append(",").append("\n");
                }
            }
            LOG.info("Adding Routes for: " + eventName);
        }
        
        LOG.warning(sb.toString());
        
        return roadRaces;
    }

}
