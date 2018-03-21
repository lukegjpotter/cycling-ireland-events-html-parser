package com.lukegjpotter.spring.application.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StageRouteMappingHolderTest {

    @Test public void testStageRouteMappingHolder() {
        long eventId = 1L;
        String stage1 = "stage1", stage2 = "stage2";
        List<String> routes = Arrays.asList(stage1, stage2);

        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventId, routes);

        assertTrue(holder.getRouteUrlMapping(eventId, "1").equals(stage1));
        assertTrue(holder.getRouteUrlMapping(eventId, "2").equals(stage2));
    }

    @Test public void testStageRouteMappingHolderNonExistingStages() {
        long eventId = 1L;
        String stage1 = "stage1";
        List<String> routes = Collections.singletonList(stage1);

        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventId, routes);

        assertTrue(holder.getRouteUrlMapping(eventId, "5").equals(""));
    }

    @Test public void testStageRouteMappingHolderNonExistingEventId() {
        long eventId = 1L;
        String stage1 = "stage1";
        List<String> routes = Collections.singletonList(stage1);

        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventId, routes);

        assertTrue(holder.getRouteUrlMapping(5L, "5").equals(""));
    }

    @Test public void testStageRouteMappingHolderCrazyStageNumber() {
        long eventId = 1L;
        String stage1 = "stage1";
        List<String> routes = Collections.singletonList(stage1);

        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventId, routes);

        assertTrue(holder.getRouteUrlMapping(eventId, "crazy").equals(""));
    }

    @Test public void testStageRouteMappingHolderEquals() {
        long eventId = 1L;
        String stage1 = "stage1";
        List<String> routes = Collections.singletonList(stage1);

        StageRouteMappingHolder holder1 = new StageRouteMappingHolder();
        holder1.putRouteUrlMapping(eventId, routes);
        StageRouteMappingHolder holder2 = new StageRouteMappingHolder();
        holder2.putRouteUrlMapping(eventId, routes);

        assertFalse(holder1.equals(null));
        assertTrue(holder1.equals(holder2));
    }
}
