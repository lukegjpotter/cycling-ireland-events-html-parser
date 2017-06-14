package com.lukegjpotter.spring.application.testresources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.util.UtilsService;

/**
 * This class is to reduce the boilerplate needed to create CSV File
 * in the other actual test classes.
 * 
 * @author lukegjpotter
 */
@Component
public class StageDetailsCsvReaderServiceTestResources {

    @Autowired UtilsService utils;
    
    public String getStagesCsvFileName2017() {
        return "./src/test/resources/StagesCsv2017.csv";
    }
    
    public StageRouteMappingHolder get2017StageRouteMappingHolder() {
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();

        // One Stage.
        Long eventId = 107619921L;
        List<String> routes = Arrays.asList("http://www.strava.com/routes/123456");
        holder.putRouteUrlMapping(eventId, routes);
        
        // Multi Stage.
        eventId = 107619922L;
        routes = Arrays.asList("http://www.strava.com/routes/111", "http://www.strava.com/routes/222", "http://www.strava.com/routes/333", "http://www.strava.com/routes/444");
        holder.putRouteUrlMapping(eventId, routes);
        
        // No Stages.
        holder.putRouteUrlMapping(107619923L, Arrays.asList(""));
        
        return holder;
    }

}
