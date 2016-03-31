package com.lukegjpotter.spring.application.parse;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

public class PageTwoParser implements Parser {

    private String pageLocation;

    public PageTwoParser(String pageLocation) {
        setPageLocation(pageLocation);
    }

    @Override
    public RoadRaceEvent parse() {
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        return roadRaceEvent;
    }

    @Override
    public void setPageLocation(String pageLocation) {
        this.pageLocation = pageLocation;
    }
}
