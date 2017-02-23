package com.lukegjpotter.spring.application.parse.y2017;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import javax.swing.Popup;

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
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.util.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, PopupDetailsParser.class })
public class PopupDetailsParserTest {

    @Autowired PopupDetailsParser popupDetailsParser;
    
    @Before public void setUp() throws Exception {}

    @Test public void testParse() {
        
        PopupDetails popup = popupDetailsParser.parse(getJsoupElementFromPopup());
        
        assertTrue(popup.getProvince().equals("Leinster"));
    }
    
    private Element getJsoupElementFromPopup() {
        
        String popupFileLocation = "src/main/resources/20170225-Popup-DWCCOpenRace.html";
        File popupHtmlFile = new File(popupFileLocation);

        Element document = null;

        try {
            document = Jsoup.parse(popupHtmlFile, Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return document;
    }
}
