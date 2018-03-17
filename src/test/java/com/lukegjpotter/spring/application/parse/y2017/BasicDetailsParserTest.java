package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicDetailsParserTest {

    @Autowired
    private BasicDetailsParser basicDetailsParser;

    @Before
    public void setUp() {
    }

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
