package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop.class })
public class ParsingLoopTest {

    @Autowired ParsingLoop parsingLoop;
    @Autowired RoadRaceEventTestResources rretr;

    @Test public void testStartParseLoopOneDayRace() {
        List<RoadRaceEvent> actual = parsingLoop.startParseLoop(rretr.getOneDayRaceFileName());
        List<RoadRaceEvent> expected = rretr.getOneDayRaceList();
        assertTrue(expected.equals(actual));
    }
}
