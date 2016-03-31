package com.lukegjpotter.spring.application.service;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.ParserFactory;

@Service
public class HtmlParsingService {

    private String pageOneLocation, pageTwoLocation;

    public RoadRaceEvent parsePageOne() {
        return ParserFactory.getPageOneParser(pageOneLocation).parse();
    }

    public RoadRaceEvent parsePageTwo() {
        return ParserFactory.getPageTwoParser(pageTwoLocation).parse();
    }

    public void setPageOneLocation(String pageOneLocation) {
        this.pageOneLocation = pageOneLocation;
    }

    public void setPageTwoLocation(String pageTwoLocation) {
        this.pageTwoLocation = pageTwoLocation;
    }
}
