package com.lukegjpotter.spring.application.parse;

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
import com.lukegjpotter.spring.application.util.Constants;

@Component
public class ParsingLoop {

    @Autowired private HeaderParser headerParser;
    @Autowired private DescriptionParser descriptionParser;
    @Autowired private StageDetailParser stageDetailParser;

    public List<RoadRaceEvent> startParseLoop(String fileLocation) {
        
        final Logger LOG = Logger.getLogger(RoadRaceEvent.class.getName());

        List<RoadRaceEvent> roadRaces = new ArrayList<>();

        Element document = null;
        try {
            document = Jsoup.parse(new File(fileLocation), Constants.FILE_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                roadRace.setStageDetails(stageDetailParser.parse(event.html()));
                isRacePopulated = true;
            }

            if (isRaceHeaderSet && isRacePopulated) {
                LOG.info("Storing: " + roadRace.toString());
                roadRaces.add(roadRace);
                roadRace = new RoadRaceEvent();
                isRaceHeaderSet = false;
                isRacePopulated = false;
            }
        }

        return roadRaces;
    }
}
