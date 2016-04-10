package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop.class })
public class ParsingLoopTest {

    @InjectMocks ParsingLoop parsingLoop;
    @Mock HeaderParser headerParser;
    @Mock DescriptionParser descriptionParser;
    @Mock StageDetailParser stageDetailParser;
    @Autowired TestResources tr;
    
    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void testStartParseLoopOneDayRace() {
        when(headerParser.parse(any(String.class))).thenReturn(tr.getOneDayRaceHeader());
        when(descriptionParser.parse(any(String.class))).thenReturn(tr.getOneDayRaceDescription());
        when(stageDetailParser.parse(any(String.class))).thenReturn(tr.getOneDayRaceStageDetails());
        List<RoadRaceEvent> actual = parsingLoop.startParseLoop(tr.getOneDayRaceFileName());
        List<RoadRaceEvent> expected = tr.getOneDayRaceList();
        assertTrue(expected.equals(actual));
    }
    
    @Test public void testStartParseLoopStageRace() {
        when(headerParser.parse(any(String.class))).thenReturn(tr.getStageRaceHeader());
        when(descriptionParser.parse(any(String.class))).thenReturn(tr.getStageRaceDescription());
        when(stageDetailParser.parse(any(String.class))).thenReturn(tr.getStageRaceStageDetails());
        List<RoadRaceEvent> actual = parsingLoop.startParseLoop(tr.getStageRaceFileName());
        List<RoadRaceEvent> expected = tr.getStageRaceList();
        assertTrue(expected.equals(actual));
    }
}
