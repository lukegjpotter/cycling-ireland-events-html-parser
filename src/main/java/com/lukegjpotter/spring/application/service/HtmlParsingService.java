package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.y2017.ParsingLoop2017;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HtmlParsingService {

    @Autowired private ParsingLoop2017 parsingLoop;
    
    private String htmlFileLocation = "";
    
    public List<RoadRaceEvent> parse() {
        return parsingLoop.startParseLoop(htmlFileLocation);
    }
}
