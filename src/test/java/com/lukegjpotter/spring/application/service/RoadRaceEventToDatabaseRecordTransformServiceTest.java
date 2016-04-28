package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
    
    List<RoadRaceEventDatabaseRecord> expected, actual;
    List<RoadRaceEvent> roadRaces;
    
    @Before public void setUp() throws Exception {
        expected = new ArrayList<>();
        actual = new ArrayList<>();
        roadRaces = new ArrayList<>();
    }

    @Test public void testTransformEmptyList() {
        actual = transformService.transform(roadRaces);
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testTransformOneItemList() {
        roadRaces = tr.getOneDayRaceList();
        actual = transformService.transform(roadRaces);
        expected = tr.getOneDayRaceDatabaseRecordList();
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testTransformMultiItemList() {
        roadRaces = tr.getTwoRaceList();
        actual = transformService.transform(roadRaces);
        expected = tr.getTwoRaceDatabaseRecordList();
        assertTrue(expected.equals(actual));
    }

}
