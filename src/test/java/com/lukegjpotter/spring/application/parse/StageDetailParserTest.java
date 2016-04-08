package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.testresources.RoadRaceEventTestResources;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, StageDetailParser.class })
public class StageDetailParserTest {

    @Autowired StageDetailParser stageDetailParser;

    @Test
    public void testParseForOneDayRace() {
        List<StageDetail> actual = stageDetailParser.parse("");
        List<StageDetail> expected = RoadRaceEventTestResources.getOneDayRaceStageDetails();
        assertTrue(expected.equals(actual));
    }

}
