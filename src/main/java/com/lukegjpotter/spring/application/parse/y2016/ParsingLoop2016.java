package com.lukegjpotter.spring.application.parse.y2016;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.DescriptionParser;
import com.lukegjpotter.spring.application.parse.HeaderParser;
import com.lukegjpotter.spring.application.parse.ParsingLoop;
import com.lukegjpotter.spring.application.parse.StageDetailParser;
import com.lukegjpotter.spring.application.util.Constants;

@Component
public class ParsingLoop2016 implements ParsingLoop {
    
    final Logger LOG = Logger.getLogger(ParsingLoop2016.class.getName());

    @Autowired private HeaderParser headerParser;
    @Autowired private DescriptionParser descriptionParser;
    @Autowired private StageDetailParser stageDetailParser;

    /* (non-Javadoc)
     * @see com.lukegjpotter.spring.application.parse.y2016.ParsingLoop#startParseLoop(java.lang.String)
     */
    @Override
    public List<RoadRaceEvent> startParseLoop(String fileLocation) {
        
        List<RoadRaceEvent> roadRaces = new ArrayList<>();
        Element document = null;
        
        try {
            document = Jsoup.parse(new File(fileLocation), Constants.FILE_FORMAT);
        } catch (IOException e) { e.printStackTrace(); }
        
        Elements allEventsTable = document.select("table#AllEventsTable");
        Element table = allEventsTable.first();
        Elements allEvents = table.getElementsByTag("tr");

        boolean isRacePopulated = false, isRaceHeaderSet = false;
        RoadRaceEvent roadRace = new RoadRaceEvent();

        for (Element event : allEvents) {

            if (event.hasAttr("style")) {
                roadRace = headerParser.parse(event.html());
                isRaceHeaderSet = true;
            } else if (isRaceHeaderSet) {
                roadRace.addDescription(descriptionParser.parse(event.html()));
                event = switchToStageDetailsElement(event);
                roadRace.setStageDetails(stageDetailParser.parse(event.html()));
                isRacePopulated = true;
            }

            if (isRaceHeaderSet && isRacePopulated) {
                LOG.fine("Storing: " + roadRace.toString());
                roadRaces.add(roadRace);
                roadRace = new RoadRaceEvent();
                isRaceHeaderSet = false;
                isRacePopulated = false;
            }
        }

        return roadRaces;
    }

    private Element switchToStageDetailsElement(Element descriptionAndStageDetailsEvent) {
        Element body = Jsoup.parseBodyFragment(descriptionAndStageDetailsEvent.html()).body();
        Element stageDetailsElement = body.getElementsByTag("table").get(1);
        
        return stageDetailsElement;
    }
}