package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.testresources.TestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, StageDetailsRaceTypesService.class })
public class StageDetailsRaceTypesServiceTest {
    
    @Autowired StageDetailsRaceTypesService categoryService;
    @Autowired TestResources tr;

    @Test public void testDetermineCategoriesEmptyCategories() {
        RaceTypesHolder expected = new RaceTypesHolder();
        RaceTypesHolder actual = categoryService.determineCategories(new ArrayList<StageDetail>());
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineCategoriesOneCategories() {
        RaceTypesHolder expected = new RaceTypesHolder();
        expected.setA1(true);
        
        List<StageDetail> stageDetails = new ArrayList<>();
        StageDetail stageDetail = new StageDetail();
        stageDetail.setRaceType("A1");
        stageDetails.add(stageDetail);
        
        RaceTypesHolder actual = categoryService.determineCategories(stageDetails);
        
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineCategoriesMultipleCategories() {
        RaceTypesHolder expected = new RaceTypesHolder();
        expected.setAPlus(true);
        expected.setA1(true);
        expected.setA2(true);
        expected.setA3(true);
        expected.setA4(true);
        expected.setVets(true);
        expected.setWoman(true);
        expected.setJunior(true);
        expected.setYouth(true);
        
        RaceTypesHolder actual = categoryService.determineCategories(tr.getStageDetailsAllTypes());
        assertTrue(expected.equals(actual));
    }
    
    @Test @Ignore public void testDetermineRaceTypesWithLongStringOfTypes() {
        // TODO Parse a race with RaceTypes = "APlus,A1,A2,A3,A4,Vets,Woman,Junior,U16,U14,U12".
    }
    
    @Test @Ignore public void testDetermineRaceTypesWithA3Junior() {
        // TODO Parse a race with RaceTypes = "A3,Junior".
    }

}
