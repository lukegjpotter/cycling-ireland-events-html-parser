package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.testresources.StageDetailsCsvReaderServiceTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class,
        StageDetailsCsvReaderService.class })
public class StageDetailsCsvReaderServiceTest {

    @Autowired StageDetailsCsvReaderService csvReader;
    @Autowired StageDetailsCsvReaderServiceTestResources tr;

    @Test(expected = NullPointerException.class) public void testReadStageRouteFromCsvFile_NoFile() {
        csvReader.setCsvFileLocation("fail");
        csvReader.readStageRouteFromCsvFile();
    }

    @Test public void testReadStageRouteFromCsvFile_2017FormatSingleStage() {
        csvReader.setCsvFileLocation(tr.getStagesCsvFileName2017());
        StageRouteMappingHolder expected = tr.get2017StageRouteMappingHolder();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

    @Ignore @Test public void testReadStageRouteFromCsvFile_OneDayRaceStages() {
        csvReader.setCsvFileLocation(tr.getOneDayRaceStagesCsvFileName());
        StageRouteMappingHolder expected = tr.getOneDayRaceStageRouteMappingHolder();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

    @Ignore @Test public void testReadStageRouteFromCsvFile_OneDayRaceNoStages() {
        csvReader.setCsvFileLocation(tr.getOneDayRaceStagesCsvFileNameNoStages());
        StageRouteMappingHolder expected = tr.getOneDayRaceStageRouteMappingHolderNoStages();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

    @Ignore @Test public void testReadStageRouteFromCsvFile_StageRaceStages() {
        csvReader.setCsvFileLocation(tr.getStageRaceStagesCsvFileName());
        StageRouteMappingHolder expected = tr.getStageRaceStageRouteMappingHolder();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

    @Ignore @Test public void testReadStageRouteFromCsvFile_StageRaceNoStages() {
        csvReader.setCsvFileLocation(tr.getStageRaceStagesCsvFileNameNoStages());
        StageRouteMappingHolder expected = tr.getStageRaceStageRouteMappingHolderNoStages();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

    @Ignore @Test public void testReadStageRouteFromCsvFile_StageRaceMissingStages() {
        csvReader.setCsvFileLocation(tr.getStageRaceStagesCsvFileNameMissingStages());
        StageRouteMappingHolder expected = tr.getStageRaceStageRouteMappingHolderMissingStages();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

    @Ignore @Test public void testReadStageRouteFromCsvFile_StageRaceMixedUpStages() {
        csvReader.setCsvFileLocation(tr.getStageRaceStagesCsvFileNameMixedUpStages());
        StageRouteMappingHolder expected = tr.getStageRaceStageRouteMappingHolder();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

}
