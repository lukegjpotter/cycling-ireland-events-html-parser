package com.lukegjpotter.spring.application.testresources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

@Component
public class BasicDetailsParserTestResources {

    public Element anchorElementWithOneDigitTime() {
        String anchor = "<a title=\"Click for event details\" class=\"cat163473\" href=\"http://www.calendarwiz.com/calendars/calendar.php?crd=CyclingirelandRoad&amp;op=cal&amp;month=8&amp;year=2018#\" onclick=\"epopup(&#39;120368236&#39;); return false;\">South of Ireland, International Youth 3 Day 9:00am </a>";
        return Jsoup.parseBodyFragment(anchor).body().getElementsByClass("cat163473").first();

    }

    public Element anchorElementWithTwoDigitTime() {
        String anchor = "<a title=\"Click for event details\" class=\"cat163473\" href=\"http://www.calendarwiz.com/calendars/calendar.php?crd=CyclingirelandRoad&amp;op=cal&amp;month=8&amp;year=2018#\" onclick=\"epopup(&#39;120368130&#39;); return false;\">Errigal International Youth Tour 3 Day 12:00pm </a>";
        return Jsoup.parseBodyFragment(anchor).body().getElementsByClass("cat163473").first();
    }
}
