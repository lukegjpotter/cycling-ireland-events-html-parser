package com.lukegjpotter.spring.application.controller.integration;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.controller.CyclingIrelandEventsHtmlScraperController;
import com.lukegjpotter.spring.application.model.RoadRaceEventDatabaseRecord;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, CyclingIrelandEventsHtmlScraperController.class })
public class CyclingIrelandEventsHtmlScraperControllerIntegrationTest {

    @Autowired CyclingIrelandEventsHtmlScraperController controller;
    @Autowired TestResources tr;
    
    @Test public void testStart() {
        List<RoadRaceEventDatabaseRecord> actual = controller.start();
        RoadRaceEventDatabaseRecord expected = tr.getFirstRaceFromHtmlFile();
        assertTrue(actual.get(0).equals(expected));
    }

}
