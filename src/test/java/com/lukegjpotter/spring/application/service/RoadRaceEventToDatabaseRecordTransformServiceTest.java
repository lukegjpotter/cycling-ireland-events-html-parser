package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.testresources.TestResources;
import com.lukegjpotter.spring.application.util.UtilsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RoadRaceEventToDatabaseRecordTransformService.class })
public class RoadRaceEventToDatabaseRecordTransformServiceTest {

    @InjectMocks RoadRaceEventToDatabaseRecordTransformService transformService;
    @Mock StageDetailsRaceTypesService raceTypeService;
    @Mock UtilsService utils;
    
    @Autowired TestResources tr;
    
    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test public void testTransformEmptyList() {
        when(raceTypeService.determineRaceTypes(any(List.class))).thenReturn(new RaceTypesHolder());
        List<RoadRaceEventDatabaseRecord> actual = transformService.transform(new ArrayList<RoadRaceEvent>());
        assertTrue(new ArrayList<RoadRaceEventDatabaseRecord>().equals(actual));
    }
    
    @Test public void testTransformOneItemList() {
        when(raceTypeService.determineRaceTypes(any(List.class))).thenReturn(tr.getOneDayRaceTypesHolder());
        List<RoadRaceEvent> roadRaces = tr.getOneDayRaceList();
        List<RoadRaceEventDatabaseRecord> expected = tr.getOneDayRaceDatabaseRecordList();
        List<RoadRaceEventDatabaseRecord> actual = transformService.transform(roadRaces);
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testTransformMultiItemList() {
        when(raceTypeService.determineRaceTypes(any(List.class))).thenReturn(tr.getOneDayRaceTypesHolder(), tr.getStageRaceTypesHolder());
        List<RoadRaceEvent> roadRaces = tr.getTwoRaceList();
        List<RoadRaceEventDatabaseRecord> expected = tr.getTwoRaceDatabaseRecordList();
        List<RoadRaceEventDatabaseRecord> actual = transformService.transform(roadRaces);
        assertTrue(expected.equals(actual));
    }

}
