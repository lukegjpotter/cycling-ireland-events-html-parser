package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RoadRaceEventHeaderParser.class })
public class RoadRaceEventHeaderParserTest {

    @Autowired RoadRaceEventHeaderParser roadRaceEventHeaderParser;
    @Autowired RoadRaceEventTestResources rretr;

    @Test public void testParseOneDayRace() {
        RoadRaceEvent actual = roadRaceEventHeaderParser.parse("");
        RoadRaceEvent expected = rretr.getOneDayRaceHeader();
        assertTrue(expected.equals(actual));
    }

}
