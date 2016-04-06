package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.StageDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class,
        StageDetailParser.class })
public class StageDetailParserTest {

    @Autowired StageDetailParser stageDetailParser;
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testParseForOneDayRace() {
        List<StageDetail> actual = stageDetailParser.parse("");
        List<StageDetail> expected = setupOneDayRaceStageDetailTestResources();

        assertTrue(actual.equals(expected));
    }

    private List<StageDetail> setupOneDayRaceStageDetailTestResources() {
        
        List<StageDetail> stageDetails = new ArrayList<>();
        
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 1, 1, "A1", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 2, 1, "A2", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 3, 1, "A3", 105, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 4, 1, "A4", 70, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 6, 1, "U14", 18, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com"));
        stageDetails.add(new StageDetail("03/04/2016", "Soccer Club", 8, 1, "Women", 70, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com"));
        
        return stageDetails;
    }
}
