package com.lukegjpotter.spring.application.model;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, StageRouteMappingHolder.class })
public class StageRouteMappingHolderTest {

    @Test public void testStageRouteMappingHolder() {
        String eventName = "EventName", stage1 = "stage1", stage2 = "stage2";
        Date date = new Date();
        List<String> routes = Arrays.asList(stage1, stage2);
        
        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventName, date, routes);
        
        assertTrue(holder.getRouteUrlMapping(eventName, date, new Integer(1)).equals(stage1));
        assertTrue(holder.getRouteUrlMapping(eventName, date, new Integer(2)).equals(stage2));

    }

}
