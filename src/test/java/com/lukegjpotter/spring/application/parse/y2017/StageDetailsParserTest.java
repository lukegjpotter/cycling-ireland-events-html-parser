package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.UtilsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, StageDetailsParser.class })
public class StageDetailsParserTest {
    
    @Autowired StageDetailsParser stageDetailsParser;
    @Autowired UtilsService utils;

    @Before public void setUp() throws Exception {}

    @Test public void testParse() {
        
        List<StageDetail> stageDetails = stageDetailsParser.parse(getJsoupElementFromPopup());
        
        Date expectedDate = utils.convertMMMMDDYYYYToDate("February 25, 2017");
        
        StageDetail stageDetail = stageDetails.get(0);
        assertTrue("Location", stageDetail.getLocation().equals("Summerhill Community Centre, Summerhill"));
        assertTrue("Date", stageDetail.getDate().equals(expectedDate));
        assertTrue("Race Number", stageDetail.getRaceNumber() == 1);
        assertTrue("Stage Number", stageDetail.getStageNumber() == 3);
        assertTrue("Race Type", stageDetail.getRaceType().equals("APlus,A1,A2"));
        assertTrue("Kilometers", stageDetail.getKilometers().equals(new Double(87.8)));
        assertTrue("Miles", stageDetail.getMiles().equals(new Double(54.6)));
        assertTrue("Category", stageDetail.getCategory().equals("Road"));
        assertTrue("Sign on Time", stageDetail.getSignOnTime().equals("09:00"));
        assertTrue("Start Time", stageDetail.getStartTime().equals("10:30"));
        assertTrue("Route URL", stageDetail.getRouteLinkUrl().equals(""));
    }
    
    private Element getJsoupElementFromPopup() {

        try {
            return Jsoup.parse(new File("src/test/resources/20170225-Stages-DWCCOpenRace.html"), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
}
