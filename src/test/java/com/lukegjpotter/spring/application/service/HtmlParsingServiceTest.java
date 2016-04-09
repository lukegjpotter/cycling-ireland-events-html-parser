package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, HtmlParsingService.class })
public class HtmlParsingServiceTest {

    @InjectMocks HtmlParsingService htmlParsingService;
    @Mock ParsingLoop parsingLoop;
    @Autowired RoadRaceEventTestResources rretr;
    
    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void testParseOneDayRace() {
        htmlParsingService.setHtmlFileLocation(rretr.getOneDayRaceFileName());
        List<RoadRaceEvent> expected = rretr.getOneDayRaceList();
        when(parsingLoop.startParseLoop(any(String.class))).thenReturn(expected);
        List<RoadRaceEvent> actual = htmlParsingService.parse();
        assertTrue(expected.equals(actual));
    }

    @Test @Ignore public void testParseStageRace() {
        htmlParsingService.setHtmlFileLocation(rretr.getStageRaceFileName());
        List<RoadRaceEvent> expected = rretr.getStageRaceList();
        List<RoadRaceEvent> actual = htmlParsingService.parse();
        assertTrue(expected.equals(actual));
    }
}
