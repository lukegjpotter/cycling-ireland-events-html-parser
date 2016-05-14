package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, MappingHolderToStageDetailsService.class })
public class MappingHolderToStageDetailsServiceTest {

    @Autowired MappingHolderToStageDetailsService mappingService;
    @Autowired TestResources tr;
    
    @Test public void testMapStageDetails_OneDayRace() {
        StageRouteMappingHolder mappingHolder = tr.getOneDayRaceStageRouteMappingHolder();
        List<RoadRaceEvent> roadRaces = tr.getOneDayRaceList();
        List<RoadRaceEvent> expected = tr.getOneDayRaceWithMappedStages();
        List<RoadRaceEvent> actual = mappingService.mapStageDetails(mappingHolder, roadRaces);
        
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testMapStageDetails_StageRace() {
        StageRouteMappingHolder mappingHolder = tr.getStageRaceStageRouteMappingHolder();
        List<RoadRaceEvent> roadRaces = tr.getStageRaceList();
        List<RoadRaceEvent> expected = tr.getStageRaceWithMappedStages();
        List<RoadRaceEvent> actual = mappingService.mapStageDetails(mappingHolder, roadRaces);
        
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testMapStageDetails_OneDayRaceNoStages() {
        StageRouteMappingHolder mappingHolder = tr.getOneDayRaceStageRouteMappingHolderNoStages();
        List<RoadRaceEvent> expected = tr.getOneDayRaceList();
        List<RoadRaceEvent> actual = mappingService.mapStageDetails(mappingHolder, expected);
        
        assertTrue(expected.equals(actual));
    }

}
