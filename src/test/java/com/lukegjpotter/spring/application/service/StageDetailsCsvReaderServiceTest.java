package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.testresources.StageDetailsCsvReaderServiceTestResources;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StageDetailsCsvReaderServiceTest {

    @Autowired
    private StageDetailsCsvReaderService csvReader;
    @Autowired
    private StageDetailsCsvReaderServiceTestResources tr;

    @Test public void testReadStageRouteFromCsvFile_NoFile() {
        csvReader.setCsvFileLocation("fail");
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();
        StageRouteMappingHolder expected = new StageRouteMappingHolder();

        assertTrue(expected.equals(actual));
    }

    @Test public void testReadStageRouteFromCsvFile_2017FormatSingleStage() {
        csvReader.setCsvFileLocation(tr.getStagesCsvFileName2017());
        StageRouteMappingHolder expected = tr.get2017StageRouteMappingHolder();
        StageRouteMappingHolder actual = csvReader.readStageRouteFromCsvFile();

        assertTrue(expected.equals(actual));
    }

}
