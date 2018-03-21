package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.testresources.ParsingLoop2017TestResources;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Ignore;
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
public class ParsingLoop2017Test {

    @InjectMocks
    private ParsingLoop2017 parsingLoop;
    //@Mock BasicDetailsParser basicDetailParser;
    @Mock
    private PopupDetailsParser popupDetailsParser;
    @Mock
    private StageDetailsParser stageDetailsParser;
    @Autowired
    private ParsingLoop2017TestResources tr;

    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
        when(popupDetailsParser.parse(any(Element.class))).thenReturn(tr.getMockPopupDetails());
        when(stageDetailsParser.parse(any(Element.class))).thenReturn(tr.getMockStageDetails());
    }

    //@Ignore // Ignoring until I can find the file 20170225-Popup-DWCCOpenRace.html
    @Test public void testStartParseLoopLocal() {

        // TODO Add some proper mocking and testing to this Test.
        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop("src/test/resources/201808-RoadEvents.html");

        assertTrue(roadRaces.get(1).getEventName().equals("Connacht A4 2 Day"));
    }

    @Ignore // Ignoring until app is able to parse from remote.
    @Test public void testStartParseLoopRemote() {

        // TODO Add some proper mocking and testing to this Test.
        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop("");

        // Problem with the HTML being returned in the remote, it doesn't have the "cat163472" in the HTML.
        assertTrue(roadRaces.get(roadRaces.size() - 1).getEventName().equals("Festive Time Trial"));
    }

}
