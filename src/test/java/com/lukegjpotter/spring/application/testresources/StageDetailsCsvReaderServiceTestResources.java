package com.lukegjpotter.spring.application.testresources;

import java.util.Arrays;
import java.util.Date;
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
    
    public String getOneDayRaceStagesCsvFileName() {
        return "./src/test/resources/DungarvanOpenRaceStages.csv";
    }

    public StageRouteMappingHolder getOneDayRaceStageRouteMappingHolder() {
        String eventName = "Dungarvan Open Race";
        Date date = utils.convertDDMMYYYYToDate("03/04/2016");
        List<String> routes = Arrays.asList("http://www.strava.com/routes/123456");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getOneDayRaceStagesCsvFileNameNoStages() {
        return "./src/test/resources/DungarvanOpenRaceStagesNoStages.csv";
    }

    public StageRouteMappingHolder getOneDayRaceStageRouteMappingHolderNoStages() {
        String eventName = "Dungarvan Open Race";
        Date date = utils.convertDDMMYYYYToDate("03/04/2016");
        List<String> routes = Arrays.asList("");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileName() {
        return "./src/test/resources/SuirValley3DayStages.csv";
    }

    public StageRouteMappingHolder getStageRaceStageRouteMappingHolder() {
        String eventName = "Suir Valley 3 Day";
        Date date = utils.convertDDMMYYYYToDate("30/07/2016");
        List<String> routes = Arrays.asList("http://www.strava.com/routes/111", "http://www.strava.com/routes/222", "http://www.strava.com/routes/333", "http://www.strava.com/routes/444");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileNameNoStages() {
        return "./src/test/resources/SuirValley3DayStagesNoStages.csv";
    }

    public StageRouteMappingHolder getStageRaceStageRouteMappingHolderNoStages() {
        String eventName = "Suir Valley 3 Day";
        Date date = utils.convertDDMMYYYYToDate("30/07/2016");
        List<String> routes = Arrays.asList("");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileNameMissingStages() {
        return "./src/test/resources/SuirValley3DayStagesMissingAStage.csv";
    }

    public StageRouteMappingHolder getStageRaceStageRouteMappingHolderMissingStages() {
        String eventName = "Suir Valley 3 Day";
        Date date = utils.convertDDMMYYYYToDate("30/07/2016");
        List<String> routes = Arrays.asList("http://www.strava.com/routes/111", "http://www.strava.com/routes/222", "", "http://www.strava.com/routes/444");
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        return holder;
    }

    public String getStageRaceStagesCsvFileNameMixedUpStages() {
        return "./src/test/resources/SuirValley3DayStages3And4MixedUp.csv";
    }
}
