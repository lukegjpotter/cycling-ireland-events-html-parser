package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RoadRaceEventToDatabaseRecordTransformService.class })
public class RoadRaceEventToDatabaseRecordTransformServiceTest {

    @Autowired RoadRaceEventToDatabaseRecordTransformService transformService;
    @Autowired TestResources tr;
    
    // TODO Mock StageDetailsRaceTypesService

    @Test public void testTransformEmptyList() {
        List<RoadRaceEventDatabaseRecord> actual = transformService.transform(new ArrayList<>());
        assertTrue(new ArrayList<RoadRaceEventDatabaseRecord>().equals(actual));
    }
    
    @Test public void testTransformOneItemList() {
        List<RoadRaceEvent> roadRaces = tr.getOneDayRaceList();
        List<RoadRaceEventDatabaseRecord> expected = tr.getOneDayRaceDatabaseRecordList();
        List<RoadRaceEventDatabaseRecord> actual = transformService.transform(roadRaces);
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testTransformMultiItemList() {
        List<RoadRaceEvent> roadRaces = tr.getTwoRaceList();
        List<RoadRaceEventDatabaseRecord> expected = tr.getTwoRaceDatabaseRecordList();
        List<RoadRaceEventDatabaseRecord> actual = transformService.transform(roadRaces);
        assertTrue(expected.equals(actual));
    }

}
