package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ParsingLoop2017Test {

    @Autowired
    private ParsingLoop2017 parsingLoop;
    //@Mock BasicDetailsParser basicDetailParser;
    //@Mock PopupDetailsParser popupDetailsParser;
    //@Mock StageDetailsParser stageDetailsParser;

    @Value("${allcievents2017file.location}")
    private String localFileLocation;

    @Before public void setup() {
        //MockitoAnnotations.initMocks(this);
    }

    @Ignore // Ignoring until I can find the file 20170225-Popup-DWCCOpenRace.html
    @Test public void testStartParseLoopLocal() {

        // TODO Add some proper mocking and testing to this Test.
        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop(localFileLocation);

        assertTrue(roadRaces.get(2).getEventName().equals("Dublin Wheelers Open Races"));
    }

    @Ignore // Ignoring until app is able to parse from remote.
    @Test public void testStartParseLoopRemote() {

        // TODO Add some proper mocking and testing to this Test.
        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop("");

        // Problem with the HTML being returned in the remote, it doesn't have the "cat163472" in the HTML.
        assertTrue(roadRaces.get(roadRaces.size() - 1).getEventName().equals("Carrickmacross Cycles New Year's Eve TT"));
    }

}
