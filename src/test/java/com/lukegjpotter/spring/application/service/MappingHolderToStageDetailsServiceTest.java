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
import com.lukegjpotter.spring.application.testresources.MappingHolderToStageDetailsServiceTestResources;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventToDatabaseRecordTransformServiceTestResources;
import com.lukegjpotter.spring.application.testresources.StageDetailsCsvReaderServiceTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, MappingHolderToStageDetailsService.class })
public class MappingHolderToStageDetailsServiceTest {

    @Autowired MappingHolderToStageDetailsService mappingService;
    @Autowired MappingHolderToStageDetailsServiceTestResources tr;
    @Autowired RoadRaceEventToDatabaseRecordTransformServiceTestResources rrtr;
    @Autowired StageDetailsCsvReaderServiceTestResources srmhtr;
    
    @Test public void testMapStageDetails_2017Format() {
        StageRouteMappingHolder mappingHolder = srmhtr.get2017StageRouteMappingHolder();
        List<RoadRaceEvent> roadRaces = rrtr.getOneDayRaceList();
        roadRaces.get(0).setId(107619921L);
        List<RoadRaceEvent> expected = tr.getOneDayRaceWithMappedStages();
        expected.get(0).setId(107619921L);
        List<RoadRaceEvent> actual = mappingService.mapStageDetails(mappingHolder, roadRaces);
        
        assertTrue(expected.equals(actual));
    }
}
