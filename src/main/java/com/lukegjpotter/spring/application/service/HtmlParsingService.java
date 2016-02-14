package com.lukegjpotter.spring.application.service;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;

@Service
public class HtmlParsingService {

    private String pageOneLocation, pageTwoLocation;

    public RoadRaceEvent parsePageOne() {
        // TODO Auto-generated method stub
        return null;
    }

    public RoadRaceEvent parsePageTwo() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setPageOneLocation(String pageOneLocation) {
        this.pageOneLocation = pageOneLocation;
    }

    public void setPageTwoLocation(String pageTwoLocation) {
        this.pageTwoLocation = pageTwoLocation;
    }
}
