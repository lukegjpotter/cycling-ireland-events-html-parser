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
import com.lukegjpotter.spring.application.testresources.RoadRaceEventTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop.class })
public class ParsingLoopTest {

    @InjectMocks ParsingLoop parsingLoop;
    @Mock RoadRaceEventHeaderParser roadRaceEventHeaderParser;
    @Mock StageDetailParser stageDetailParser;
    @Autowired RoadRaceEventTestResources rretr;
    
    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void testStartParseLoopOneDayRace() {
        when(roadRaceEventHeaderParser.parse(any(String.class))).thenReturn(rretr.getOneDayRaceHeader());
        when(stageDetailParser.parse(any(String.class))).thenReturn(rretr.getOneDayRaceStageDetails());
        List<RoadRaceEvent> actual = parsingLoop.startParseLoop(rretr.getOneDayRaceFileName());
        List<RoadRaceEvent> expected = rretr.getOneDayRaceList();
        assertTrue(expected.equals(actual));
    }
}
