package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, ParsingLoop2017.class })
public class ParsingLoop2017Test {
    
    @InjectMocks ParsingLoop2017 parsingLoop;
    @Mock BasicDetailsParser basicDetailParser;

    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test public void testStartParseLoop() {
        // TODO Add some proper mocking and testing to this Test.
        
        parsingLoop.startParseLoop("");
        
        assertTrue(true);
    }

}
