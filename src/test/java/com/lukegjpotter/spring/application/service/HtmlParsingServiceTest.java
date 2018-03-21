package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.y2017.ParsingLoop2017;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventToDatabaseRecordTransformServiceTestResources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HtmlParsingServiceTest {

    @InjectMocks
    private HtmlParsingService htmlParsingService;
    @Mock
    private ParsingLoop2017 parsingLoop2017;
    @Autowired
    private RoadRaceEventToDatabaseRecordTransformServiceTestResources tr;

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
