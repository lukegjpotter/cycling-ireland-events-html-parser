package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop2017.class })
public class ParsingLoop2017Test {
    
    @Autowired ParsingLoop2017 parsingLoop;
    //@Mock BasicDetailsParser basicDetailParser;
    //@Mock PopupDetailsParser popupDetailsParser;
    //@Mock StageDetailsParser stageDetailsParser;

    @Before public void setup() {
        //MockitoAnnotations.initMocks(this);
    }
    
    @Test public void testStartParseLoopLocal() {
        
        // TODO Add some proper mocking and testing to this Test.
        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop("Local");
        
        assertTrue(roadRaces.get(2).getEventName().equals("Dublin Wheelers Open Races"));
    }
    
    @Test public void testStartParseLoopRemote() {
        
        // TODO Add some proper mocking and testing to this Test.
        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop("");
        
        // Problem with the HTML being returned in the remote, it doesn't have the "cat163472" in the HTML.
        assertTrue(roadRaces.get(roadRaces.size() - 1).getEventName().equals("Carrickmacross Cycles New Year's Eve TT"));
    }

}
