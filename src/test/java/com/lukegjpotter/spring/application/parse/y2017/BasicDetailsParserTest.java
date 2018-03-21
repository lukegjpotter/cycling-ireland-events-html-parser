package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.testresources.BasicDetailsParserTestResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BasicDetailsParserTest {

    @Autowired
    private BasicDetailsParser basicDetailsParser;
    @Autowired
    private BasicDetailsParserTestResources tr;

    @Test public void testParseOneDigitHourTime() {

        RoadRaceEvent roadRaceEvent = basicDetailsParser.parse(tr.anchorElementWithOneDigitTime());

        long expectedId = 120368236;
        String expectedName = "South of Ireland, International Youth 3 Day";

        String idFailMessage = String.format("ID: Expected: %d, Actual: %d", expectedId, roadRaceEvent.getId());
        String nameFailMessage = String.format("Name: Expected: %s, Actual: %s", expectedName, roadRaceEvent.getEventName());

        assertTrue(idFailMessage, roadRaceEvent.getId() == expectedId);
        assertTrue(nameFailMessage, roadRaceEvent.getEventName().equals(expectedName));
    }

    @Test public void testParseTwoDigitHourTime() {

        RoadRaceEvent roadRaceEvent = basicDetailsParser.parse(tr.anchorElementWithTwoDigitTime());

        long expectedId = 120368130;
        String expectedName = "Errigal International Youth Tour 3 Day";

        String idFailMessage = String.format("ID: Expected: %d, Actual: %d", expectedId, roadRaceEvent.getId());
        String nameFailMessage = String.format("Name: Expected: %s, Actual: %s", expectedName, roadRaceEvent.getEventName());

        assertTrue(idFailMessage, roadRaceEvent.getId() == expectedId);
        assertTrue(nameFailMessage, roadRaceEvent.getEventName().equals(expectedName));
    }
}
