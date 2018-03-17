package com.lukegjpotter.spring.application.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StageRouteMappingHolderTest {

    @Test public void testStageRouteMappingHolder() {
        long eventId = 1L;
        String stage1 = "stage1", stage2 = "stage2";
        List<String> routes = Arrays.asList(stage1, stage2);

        StageRouteMappingHolder holder = new StageRouteMappingHolder();
        holder.putRouteUrlMapping(eventId, routes);

        assertTrue(holder.getRouteUrlMapping(eventId, 1).equals(stage1));
        assertTrue(holder.getRouteUrlMapping(eventId, 2).equals(stage2));

    }

}
