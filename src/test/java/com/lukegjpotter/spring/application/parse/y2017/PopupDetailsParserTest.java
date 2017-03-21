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
        
        PopupDetails popup = popupDetailsParser.parse(getJsoupElementFromPopup());
        
        Date expectedDate = utils.convertMMMMDDYYYYToDate("February 25, 2017");
        
        assertTrue(expectedDate.equals(popup.getStartDate()));
        assertTrue(popup.getProvince().equals("Leinster"));
        assertTrue(popup.getCategory().equals("Road"));
        assertTrue(popup.getPromotingClub().equals("Dublin Wheelers"));
        assertTrue(popup.getOrganiserName().equals("Brian Carolan"));
        assertTrue(popup.getOrganiserEmail().equals("dwcc.gp@gmail.com"));
        assertTrue(popup.getOrganiserPhoneNumber().equals("+353866044136"));
        assertTrue(popup.getMoreInfoUrl().getAuthority().equals("cyclingirelandlegacy.azolve.com"));
        assertTrue(popup.getMoreInfoUrl().getFile().equals("/portal/Moreeventdetails.aspx?EventId=298200"));
    }
    
    private Element getJsoupElementFromPopup() {

        try {
            return Jsoup.parse(new File("src/test/resources/20170225-Popup-DWCCOpenRace.html"), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }

        return null;
    }
}
