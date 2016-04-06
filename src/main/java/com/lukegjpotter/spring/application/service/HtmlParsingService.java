package com.lukegjpotter.spring.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.ParsingLoop;

@Service
public class HtmlParsingService {

    private String htmlFileLocation;
    @Autowired
    private ParsingLoop parsingLoop;

    public List<RoadRaceEvent> parse() {

        return parsingLoop.startParseLoop(htmlFileLocation);
    }

    public void setHtmlFileLocation(String htmlFileLocation) {
        this.htmlFileLocation = htmlFileLocation;
    }

    public void setParsingLoop(ParsingLoop parsingLoop) {
        this.parsingLoop = parsingLoop;
    }
}
