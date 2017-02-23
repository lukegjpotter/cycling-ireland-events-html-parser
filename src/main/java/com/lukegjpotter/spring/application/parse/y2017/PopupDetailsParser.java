package com.lukegjpotter.spring.application.parse.y2017;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.Parsable;

/**
 * Extracts the Date, Time, Province, Category, Promoting Club, Contact
 * Person's Information and the More Info Link from the Popup;
 * 
 * @author lukegjpotter - Luke GJ Potter
 */
@Component
class PopupDetailsParser implements Parsable<Element, RoadRaceEvent> {

    @Override public RoadRaceEvent parse(Element htmlToParse) {
        // TODO Auto-generated method stub
        return null;
    }

}
