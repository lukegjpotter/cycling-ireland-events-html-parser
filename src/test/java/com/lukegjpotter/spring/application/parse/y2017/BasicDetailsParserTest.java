package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, BasicDetailsParser.class })
public class BasicDetailsParserTest {
    
    @Autowired BasicDetailsParser basicDetailsParser;

    @Before public void setUp() throws Exception {}

    @Test public void testParseOneDigitHourTime() {
        
        Element anchor = Jsoup.parseBodyFragment("<a title=\"Click for event details\" class=\"cat163473\" href=\"#\" onclick=\"epopup('107619903'); return false;\"> Phoenix GP 9:30 am </a>").body().getElementsByClass("cat163473").first();
        RoadRaceEvent roadRaceEvent = basicDetailsParser.parse(anchor);
        
        assertTrue(roadRaceEvent.getId() == 107619903);
        assertTrue(roadRaceEvent.getEventName().equals("Phoenix GP"));
    }
    
    @Test public void testParseTwoDigitHourTime() {
        
        Element anchor = Jsoup.parseBodyFragment("<a title=\"Click for event details\" class=\"cat163473\" href=\"#\" onclick=\"epopup('107619903'); return false;\"> Phoenix GP 10:30 am </a>").body().getElementsByClass("cat163473").first();
        RoadRaceEvent roadRaceEvent = basicDetailsParser.parse(anchor);
        
        assertTrue(roadRaceEvent.getId() == 107619903);
        assertTrue(roadRaceEvent.getEventName().equals("Phoenix GP"));
    }
}
