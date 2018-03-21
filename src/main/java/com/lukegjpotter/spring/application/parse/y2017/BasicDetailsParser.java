package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.parse.Parsable;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Gets the Name and ID of the RoadRaceEvent from the Calendar Web Page.
 * 
 * @author lukegjpotter - Luke GJ Potter
 */
@Component
class BasicDetailsParser implements Parsable<Element, RoadRaceEvent> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * This method will extract the ID and Name of the Race from the HMTL Element.
     * The Input Element will be as follows:
     * {@code <a title="Click for event details" class="cat163473" href="#" onclick="epopup('107619903'); return false;"> Phoenix GP 9:30 am </a>}
     * 
     * @return {@code RoadRaceEvent} with the ID and EventName filled out.
     */
    @Override public RoadRaceEvent parse(Element htmlElementToParse) {

        long eventId = extractEventId(htmlElementToParse.attr("onclick"));
        String eventName = extractEventName(htmlElementToParse.text().trim());
        
        RoadRaceEvent roadRaceEvent = new RoadRaceEvent();
        roadRaceEvent.setId(eventId);
        roadRaceEvent.setEventName(eventName);

        log.info("Parsing Road Race: {}, Popup ID: {}", eventName, eventId);
        
        return roadRaceEvent;
    }

    /**
     * This method will extract the Event ID from the onClick Listener Text.
     * Example: Extract 107619903 from {@code "epopup('107619903'); return false;"}.
     *
     * @param eventIdAndOnClick String with Event ID to parse
     * @return The Event ID in long.
     */
    private long extractEventId(String eventIdAndOnClick) {
        return Long.parseLong(eventIdAndOnClick.replace("epopup(\'", "").replace("\'); return false;", "").trim());
    }
    
    /**
     * Extracts the Event's Name from the Text of the HTML Element.
     * Example: Extracts "Phoenix GP" from {@code " Phoenix GP 9:30am "}.
     *
     * @param eventNameAndTime String to Parse
     * @return Event Name
     */
    private String extractEventName(String eventNameAndTime) {

        // -8 because it will at least be " x:yztm" and text the next character.
        int startIndexOfTime = eventNameAndTime.length() - 7;

        if (Character.isDigit(eventNameAndTime.charAt(eventNameAndTime.length() - 7))) {
            startIndexOfTime = eventNameAndTime.length() - 8;
        }

        return eventNameAndTime.substring(0, startIndexOfTime).trim();
    }
}
