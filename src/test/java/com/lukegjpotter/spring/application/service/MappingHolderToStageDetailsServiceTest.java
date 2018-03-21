package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.testresources.MappingHolderToStageDetailsServiceTestResources;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventToDatabaseRecordTransformServiceTestResources;
import com.lukegjpotter.spring.application.testresources.StageDetailsCsvReaderServiceTestResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MappingHolderToStageDetailsServiceTest {

    @Autowired
    private MappingHolderToStageDetailsService mappingService;
    @Autowired
    private MappingHolderToStageDetailsServiceTestResources tr;
    @Autowired
    private RoadRaceEventToDatabaseRecordTransformServiceTestResources rrtr;
    @Autowired
    private StageDetailsCsvReaderServiceTestResources srmhtr;

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
