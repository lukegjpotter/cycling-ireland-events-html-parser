package com.lukegjpotter.spring.application.parse.y2016;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.DescriptionParser;
import com.lukegjpotter.spring.application.parse.HeaderParser;
import com.lukegjpotter.spring.application.parse.StageDetailParser;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop2016.class })
public class ParsingLoop2016Test {

    @InjectMocks ParsingLoop2016 parsingLoop;
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
    
    @Test public void testStartParseLoopTwoRaces() {
        when(headerParser.parse(any(String.class))).thenReturn(tr.getOneDayRaceHeader(), tr.getStageRaceHeader());
        when(descriptionParser.parse(any(String.class))).thenReturn(tr.getOneDayRaceDescription(), tr.getStageRaceDescription());
        when(stageDetailParser.parse(any(String.class))).thenReturn(tr.getOneDayRaceStageDetails(), tr.getStageRaceStageDetails());
        List<RoadRaceEvent> actual = parsingLoop.startParseLoop(tr.getTwoRacesFileName());
        List<RoadRaceEvent> expected = tr.getTwoRaceList();
        verify(headerParser, times(2)).parse(any(String.class));
        verify(descriptionParser, times(2)).parse(any(String.class));
        verify(stageDetailParser, times(2)).parse(any(String.class));
        assertTrue(expected.equals(actual));
    }
    
    @Test(expected=NullPointerException.class) public void testStartParseLoopNoSuchFile() {
        List<RoadRaceEvent> actual = parsingLoop.startParseLoop("Danny");
        assertTrue(actual.equals(new ArrayList<RoadRaceEvent>()));
    }
}
