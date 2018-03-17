package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.testresources.StageDetailsRaceTypesServiceTestResources;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StageDetailsRaceTypesServiceTest {

    @Autowired
    private StageDetailsRaceTypesService raceTypeService;
    @Autowired
    private StageDetailsRaceTypesServiceTestResources tr;

    private List<StageDetail> stageDetails = new ArrayList<>();

    @Before public void setUp() {
        StageDetail stageDetail = new StageDetail();
        stageDetails.add(stageDetail);
    }

    @Test public void testDetermineRaceTypesEmptyRaceTypes() {
        RaceTypesHolder expected = new RaceTypesHolder();
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(new ArrayList<>());
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineRaceTypesOneRaceType() {
        RaceTypesHolder expected = new RaceTypesHolder();
        expected.setA1(true);
        stageDetails.get(0).setRaceType("A1");
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(stageDetails);
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineRaceTypesMultipleRaceTypesSeparateStageDetails() {
        RaceTypesHolder expected = tr.getRaceTypesAllEnabled();
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(tr.getStageDetailsAllTypes());
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineRaceTypesStringYouthRaces() {
        RaceTypesHolder expected = new RaceTypesHolder();
        expected.setYouth(true);
        stageDetails.get(0).setRaceType("U16,U14,U12,U10");
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(stageDetails);
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineRaceTypesStringVetsRaces() {
        RaceTypesHolder expected = new RaceTypesHolder();
        expected.setVets(true);
        stageDetails.get(0).setRaceType("M40,M50,M60");
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(stageDetails);
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineRaceTypesStringParacyclingRaces() {
        RaceTypesHolder expected = new RaceTypesHolder();
        expected.setParacycling(true);
        stageDetails.get(0).setRaceType("Tandem_B1_B3,HandCycling_H1_H5,SoloBikes_C1_C5,Tricycle_T1_T3");
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(stageDetails);
        assertTrue(expected.equals(actual));
    }

    @Test public void testDetermineRaceTypesWithStringOfTypes() {
        RaceTypesHolder expected = tr.getRaceTypesAllEnabled();
        expected.setYouth(false);
        stageDetails.get(0).setRaceType("APlus,A1,A2,A3,A4,Vets,Women,Junior");
        RaceTypesHolder actual = raceTypeService.determineRaceTypes(stageDetails);
        assertTrue(expected.equals(actual));
    }

}
