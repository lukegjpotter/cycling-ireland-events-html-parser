package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

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
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.y2017.ParsingLoop2017;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventToDatabaseRecordTransformServiceTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, HtmlParsingService.class })
public class HtmlParsingServiceTest {

    @InjectMocks HtmlParsingService htmlParsingService;
    @Mock ParsingLoop2017 parsingLoop2017;
    @Autowired RoadRaceEventToDatabaseRecordTransformServiceTestResources tr;
    
    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void testParseOneDayRace() {
        List<RoadRaceEvent> expected = tr.getOneDayRaceList();
        when(parsingLoop2017.startParseLoop(any(String.class))).thenReturn(expected);
        List<RoadRaceEvent> actual = htmlParsingService.parse();
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testParseStageRace() {
        List<RoadRaceEvent> expected = tr.getStageRaceList();
        when(parsingLoop2017.startParseLoop(any(String.class))).thenReturn(expected);
        List<RoadRaceEvent> actual = htmlParsingService.parse();
        assertTrue(expected.equals(actual));
    }

}
