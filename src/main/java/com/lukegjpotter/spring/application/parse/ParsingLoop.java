package com.lukegjpotter.spring.application.parse;

import java.util.List;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

public interface ParsingLoop {

    List<RoadRaceEvent> startParseLoop(String fileLocation);

}