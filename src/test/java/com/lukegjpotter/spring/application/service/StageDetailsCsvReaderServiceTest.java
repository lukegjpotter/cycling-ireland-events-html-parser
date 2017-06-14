package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

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

}
