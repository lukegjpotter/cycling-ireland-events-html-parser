package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;
import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.UtilsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, PopupDetailsParser.class })
public class PopupDetailsParserTest {

    @Autowired PopupDetailsParser popupDetailsParser;
    @Autowired UtilsService utils;
    
    @Before public void setUp() throws Exception {}

    @Test public void testParse() {
        
        PopupDetails popup = popupDetailsParser.parse(getJsoupElementFromPopup("src/test/resources/20170806-Popup-OldcastleGP.html"));
        
        Date expectedDate = utils.convertMMMDDYYYYToDate("Aug 6, 2017");
        
        assertTrue(expectedDate.equals(popup.getStartDate()));
        assertTrue(popup.getProvince().equals("Leinster"));
        assertTrue(popup.getCategory().equals("Road"));
        assertTrue(popup.getPromotingClub().equals("Oldcastle CC"));
        assertTrue(popup.getOrganiserName().equals("Alan Surname"));
        assertTrue(popup.getOrganiserEmail().equals("racing1team@gmail.com"));
        assertTrue(popup.getOrganiserPhoneNumber().equals("+353879349161"));
        assertTrue(popup.getMoreInfoUrl().getAuthority().equals("cyclingirelandlegacy.azolve.com"));
        assertTrue(popup.getMoreInfoUrl().getFile().equals("/portal/Moreeventdetails.aspx?EventId=298400"));
    }
    
    @Test public void testParseNoOrganiserEmail() {
        
        PopupDetails popup = popupDetailsParser.parse(getJsoupElementFromPopup("src/test/resources/20170701-Popup-BolivarGP-NoOrgEmail.html"));
                
        assertTrue("Organiser Name", popup.getOrganiserName().equals("Alan Surname"));
        assertTrue("Organiser Email", popup.getOrganiserEmail().equals(""));
        assertTrue("Phone Number", popup.getOrganiserPhoneNumber().equals("+353872727811"));
    }
    
    private Element getJsoupElementFromPopup(String fileName) {

        try {
            return Jsoup.parse(new File(fileName), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }

        return null;
    }
}
