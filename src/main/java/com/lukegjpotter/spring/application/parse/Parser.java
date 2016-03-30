package com.lukegjpotter.spring.application.parse;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

public interface Parser {
    
    public RoadRaceEvent parse();
    public void setPageLocation(String pageLocation);
}
