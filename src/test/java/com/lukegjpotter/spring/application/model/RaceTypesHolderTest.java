package com.lukegjpotter.spring.application.model;

import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, RaceTypesHolder.class })
public class RaceTypesHolderTest {

   @Test public void testEqualsOtherObject() {
        assertFalse(new RaceTypesHolder().equals(new Date()));
    }

}
