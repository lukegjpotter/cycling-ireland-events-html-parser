package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Ignore;
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
        
        Date expectedDate = utils.convertMMMDDYYYYToDate("Aug 6, 2017");
        
        StageDetail stageDetail = stageDetails.get(0);
        assertTrue("Location", stageDetail.getLocation().equals("TBC, Oldcastle"));
        assertTrue("Date", stageDetail.getDate().equals(expectedDate));
        assertTrue("Race Number", stageDetail.getRaceNumber() == 1);
        assertTrue("Stage Number", stageDetail.getStageNumber() == 1);
        assertTrue("Race Type", stageDetail.getRaceType().equals("APlus,A1,A2,A3,A4,Women"));
        assertTrue("Kilometers", stageDetail.getKilometers().equals(new Double(100.0)));
        assertTrue("Miles", stageDetail.getMiles().equals(new Double(62.1)));
        assertTrue("Category", stageDetail.getCategory().equals("Road"));
        assertTrue("Sign on Time", stageDetail.getSignOnTime().equals("09:00"));
        assertTrue("Start Time", stageDetail.getStartTime().equals("12:00"));
        assertTrue("Route URL", stageDetail.getRouteLinkUrl().equals(""));
        assertTrue("Additional Info", stageDetail.getAdditionalInfo().equals(getOldcastleAdditionalInfo()));
    }

    @Ignore @Test public void testParseWithErrorPage() {
        // TODO: Use the file "StagesError.html" to ensure that the content loaded is of the correct format.
    }
    
    private Element getJsoupElementFromPopup() {

        try {
            return Jsoup.parse(new File("src/test/resources/20170806-Stages-OldcastleGP.html"), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
    
    private String getOldcastleAdditionalInfo() {
        return "Ideally this will be a 100-120km race for all cats. It would be great to have on this date as the Mountnugent GP is on the previous night in same area and riders will stay locally and race the next day.";
    }
}
