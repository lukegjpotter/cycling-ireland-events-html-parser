package com.lukegjpotter.spring.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.y2017.ParsingLoop2017;

@Service
public class HtmlParsingService {

    @Value("${allcievents2017file.location}") private String htmlFileLocation;
    @Autowired private ParsingLoop2017 parsingLoop;

    public List<RoadRaceEvent> parse() {
        return parsingLoop.startParseLoop(htmlFileLocation);
    }

    public void setHtmlFileLocation(String htmlFileLocation) {
        this.htmlFileLocation = htmlFileLocation;
    }
}
