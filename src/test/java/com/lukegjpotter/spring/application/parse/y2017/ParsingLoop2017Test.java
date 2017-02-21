package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop2017.class })
public class ParsingLoop2017Test {
    
    @Autowired ParsingLoop2017 parsingLoop;

    @Test public void testStartParseLoop() {
        parsingLoop.startParseLoop("");
        
        assertTrue(true);
    }

}
