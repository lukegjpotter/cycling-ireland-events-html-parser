package com.lukegjpotter.spring.application.parse.y2017;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.Parsable;

@Component
class BasicDetailsParser implements Parsable<Element, RoadRaceEvent> {

    /**
     * This method will extract the ID and Name of the Race from the HMTL Element.
     * The Input Element will be as follows:
     * {@code <a title="Click for event details" class="cat163473" href="#" onclick="epopup('107619903'); return false;"> Phoenix GP 9:30 am </a>}
     * 
     * @return {@code RoadRaceEvent} with the ID and EventName filled out.
     */
    @Override public RoadRaceEvent parse(Element htmlElementToParse) {
        
        long eventId = stripOnClick(htmlElementToParse.attr("onclick"));
        String eventName = stripTime(htmlElementToParse.text());
        
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        roadRaceEvent.setId(eventId);
        roadRaceEvent.setEventName(eventName);
        
        return roadRaceEvent;
    }

    /**
     * This method will extract the Event ID from the onClick Listener Text.
     * Example: Extract 107619903 from {@code "epopup('107619903'); return false;"}.
     * 
     * @param eventIdAndOnClick
     * @return The Event ID in long.
     */
    private long stripOnClick(String eventIdAndOnClick) {
        return Long.parseLong(eventIdAndOnClick.replace("epopup(\'", "").replace("\'); return false;", "").trim());
    }
    
    /**
     * Extracts the Event's Name from the Text of the HTML Element.
     * Example: Extracts "Phoenix GP" from {@code " Phoenix GP 9:30 am "}.
     * 
     * @param eventNameAndTime
     * @return
     */
    private String stripTime(String eventNameAndTime) {
        
        // -8 because it will at least be " x:yz tm" and text the next character.
        int startIndexOfTime = eventNameAndTime.length() - 8;
        
        if (Character.isDigit(eventNameAndTime.charAt(eventNameAndTime.length() - 8))) {
            startIndexOfTime = eventNameAndTime.length() - 9;
        }
        
        String eventName = eventNameAndTime.substring(0, startIndexOfTime).trim();
        
        return eventName;
    }
}
