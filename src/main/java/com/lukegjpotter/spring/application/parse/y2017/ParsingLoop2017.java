package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.service.UrlMonthService;
import com.lukegjpotter.spring.application.util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParsingLoop2017 implements ParsingLoop {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlMonthService urlMonthService;
    @Autowired
    private BasicDetailsParser basicDetailsParser;
    @Autowired
    private PopupDetailsParser popupDetailsParser;
    @Autowired
    private StageDetailsParser stageDetailsParser;
    
    @Value("${url.popup}") private String urlPopupWithPlaceholder;
    private String localPopupFile, localStagesFile;

    private String fileLocation;
    private boolean isRemote;
    
    @Override public List<RoadRaceEvent> startParseLoop(String fileLocation) {

        List<RoadRaceEvent> roadRaceEvents = new ArrayList<>();
        this.fileLocation = fileLocation;
        isRemote = fileLocation.isEmpty();

        List<Element> documents = populateListOfElementsWithHtmlForRemainingMonthsInYear();
        
        for (Element document : documents) {
            
            Elements allAnchors = document.getElementsByClass("cat163473");
            
            for (Element event : allAnchors) {
                
                // Get Basic Details; ID and Name.
                RoadRaceEvent roadRace = basicDetailsParser.parse(event);

                // Get Popup Details; Date, Province, Category, Promoting Club, Contact Person, More Info.
                log.info("Parsing Road Race: {}, Popup URL: {}", roadRace.getEventName(), String.format(getUrlPopupWithPlaceholder(), roadRace.getId()));
                Element popupElement = makePopupDetailsElementFromRoadRaceId(roadRace.getId());
                PopupDetails popupDetails = popupDetailsParser.parse(popupElement);
                roadRace.addPopupDetails(popupDetails);
                
                // Get More Information Link Details AKA StageDetails.
                log.info("Parsing Road Race: {}, Stages URL: {}", roadRace.getEventName(), popupDetails.getMoreInfoUrl().toString());
                Element stageDetailsElement = makeStageDetailsElementFromMoreInfoUrl(popupDetails.getMoreInfoUrl());
                roadRace.setStageDetails(stageDetailsParser.parse(stageDetailsElement));
                roadRace.setLocation(roadRace.getStageDetails().get(0).getLocation());
                
                roadRaceEvents.add(roadRace);
            }
        }

        return roadRaceEvents;
    }

    private Element makePopupDetailsElementFromRoadRaceId(long eventId) {

        try {
            if (isRemote) {
                return Jsoup.connect(String.format(getUrlPopupWithPlaceholder(), eventId)).get();
            }
            return Jsoup.parse(new File(getLocalPopupFile()), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }
    
    private Element makeStageDetailsElementFromMoreInfoUrl(URL moreInfoUrl) {
        
        try {
            if (isRemote) {
                return Jsoup.connect(moreInfoUrl.toString()).get();
            }
            return Jsoup.parse(new File(getLocalStagesFile()), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        return null;
    }

    private List<Element> populateListOfElementsWithHtmlForRemainingMonthsInYear() {
        
        List<Element> documents = new ArrayList<>();
        
        if (isRemote) {
            // Populate the list of Documents with Remote URLs.
            List<String> urls = urlMonthService.compileUrlsForRemainingYearMonths();
            
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            WebDriver driver = new PhantomJSDriver(caps);
            
            for (String url : urls) {
                
                log.info("Url: {}", url);
                
                // Load the URL with PhantomJs, as the initial page loads JavaScipt, PhantomJS will load the HTML.
                driver.get(url);
                String sourceHtml = driver.getPageSource();
                
                // Use Jsoup to parse the HTML.
                Element remoteDocument = Jsoup.parseBodyFragment(sourceHtml);
                documents.add(remoteDocument);
            }
            
            driver.close();
        } else {
            // Populate the list of Documents with the file path.
            Element localDocument;
            
            try {
                localDocument = Jsoup.parse(new File(fileLocation), Constants.FILE_FORMAT);
                documents.add(localDocument);
            } catch (IOException e) { e.printStackTrace(); }
        }

        return documents;
    }

    // ----- Getters and Setters Needed For The Unit Tests ----- //
    private String getUrlPopupWithPlaceholder() {
        return urlPopupWithPlaceholder;
    }

    public void setUrlPopupWithPlaceholder(String url) {
        this.urlPopupWithPlaceholder = url;
    }

    private String getLocalPopupFile() {
        return localPopupFile;
    }

    public void setLocalPopupFile(String path) {
        this.localPopupFile = path;
    }

    private String getLocalStagesFile() {
        return localStagesFile;
    }

    public void setLocalStagesFile(String localStagesFile) {
        this.localStagesFile = localStagesFile;
    }
}
