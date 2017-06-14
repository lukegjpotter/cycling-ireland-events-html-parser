package com.lukegjpotter.spring.application.controller.integration;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.controller.CyclingIrelandEventsHtmlScraperController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, CyclingIrelandEventsHtmlScraperController.class })
public class CyclingIrelandEventsHtmlScraperControllerIntegrationTest {

    @Autowired CyclingIrelandEventsHtmlScraperController controller;
    
    @Test public void testStart() {
        String actual = controller.start();
        String expected = "Success";
        assertTrue(actual.equals(expected));
    }

}
