package com.lukegjpotter.spring.application.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.model.StageDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class,
        HtmlParsingService.class })
public class HtmlParsingServiceTest {

    @Autowired
    private HtmlParsingService htmlParsingService;
    private RoadRaceEvent expectedPageOne, expectedPageTwo;
    private List<StageDetail> expectedPageTwoStageDetails;

    @Before
    public void setUp() throws Exception {
        // From
        // http://www.calendarwiz.com/calendars/popup.php?op=view&id=97494293&crd=CyclingirelandRoad&PHPSESSID=f903f9e0ec4831608ffd48836a4de793
        htmlParsingService.setPageOneLocation("./src/test/resources/Page1-SuirValleyThreeDay.html");
        // From
        // https://cyclingireland.azolve.com/portal/Moreeventdetails.aspx?EventId=213961
        htmlParsingService.setPageTwoLocation("/src/test/resources/Page2-SuirValleyThreeDay.html");

        expectedPageOne = new RoadRaceEvent("Suir Valley 3 Day", "Saturday", "July 30, 2016", "8:00am", "Munster",
                "Road", "Clonmel CC", "Declan Byrne", "declanbyrne2006@gmail.com", "3.53879E+11",
                "https://cyclingireland.azolve.com/portal/Moreeventdetails.aspx?EventId=213961", "Munster, Munster");

//        expectedPageTwoStageDetails.add(new StageDetail("30/07/2016", 1, "1", "APlus,A1,A2,A3", 120, 74.6, "Road",
//                "9.30", "13.00", "http://www.suirvalley3day.com/"));
//        expectedPageTwoStageDetails.add(new StageDetail("31/07/2016", 1, "2", "APlus,A1,A2,A3", 92, 57.2, "Road",
//                "9.30", "11.00", "http://www.suirvalley3day.com/"));
//        expectedPageTwoStageDetails.add(new StageDetail("31/07/2016", 1, "3", "APlus,A1,A2,A3", 35, 21.7, "Criterium",
//                "18.00", "19.00", "http://www.suirvalley3day.com/"));
//        expectedPageTwoStageDetails.add(new StageDetail("01/08/2016", 1, "4", "APlus,A1,A2,A3", 122, 75.8, "Road",
//                "9.30", "11.00", "http://www.suirvalley3day.com/"));
//
//        expectedPageTwo = new RoadRaceEvent("HEARNS HOTEL, CLONMEL", "01/08/2016", expectedPageTwoStageDetails);
    }

    @Test
    public void testParsePageOne() {
        RoadRaceEvent actualPageOne = htmlParsingService.parsePageOne();
        assertTrue("Expected: " + expectedPageOne.getEventName() + ". Actual: " + actualPageOne.getEventName(), expectedPageOne.getEventName().equals(actualPageOne.getEventName()));
        assertTrue("Expected: " + expectedPageOne.getStartDay() + ". Actual: " + actualPageOne.getStartDay(), expectedPageOne.getStartDay().equals(actualPageOne.getStartDay()));
        assertTrue("Expected: " + expectedPageOne.getStartDate() + ". Actual: " + actualPageOne.getStartDate(), expectedPageOne.getStartDate().equals(actualPageOne.getStartDate()));
        assertTrue("Expected: " + expectedPageOne.getSignOnTime() + ". Actual: " + actualPageOne.getSignOnTime(), expectedPageOne.getSignOnTime().equals(actualPageOne.getSignOnTime()));
        assertTrue("Expected: " + expectedPageOne.getProvince() + ". Actual: " + actualPageOne.getProvince(), expectedPageOne.getProvince().equals(actualPageOne.getProvince()));
        assertTrue("Expected: " + expectedPageOne.getCategory() + ". Actual: " + actualPageOne.getCategory(), expectedPageOne.getCategory().equals(actualPageOne.getCategory()));
        assertTrue("Expected: " + expectedPageOne.getPromotingClub() + ". Actual: " + actualPageOne.getPromotingClub(), expectedPageOne.getPromotingClub().equals(actualPageOne.getPromotingClub()));
    }

    @Test @Ignore
    public void testParsePageTwo() {
        RoadRaceEvent actualPageTwo = htmlParsingService.parsePageTwo();
        assertTrue(expectedPageTwo.equals(actualPageTwo));
    }
}
