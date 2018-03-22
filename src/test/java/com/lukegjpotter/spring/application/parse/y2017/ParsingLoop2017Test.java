package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.RoadRaceEvent;
import com.lukegjpotter.spring.application.service.UrlMonthService;
import com.lukegjpotter.spring.application.testresources.ParsingLoop2017TestResources;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParsingLoop2017Test {

    @InjectMocks
    private ParsingLoop2017 parsingLoop;
    @Mock
    private BasicDetailsParser basicDetailParser;
    @Mock
    private PopupDetailsParser popupDetailsParser;
    @Mock
    private StageDetailsParser stageDetailsParser;
    @Mock
    private UrlMonthService urlMonthService;
    @Autowired
    private ParsingLoop2017TestResources tr;

    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
        when(basicDetailParser.parse(any(Element.class))).thenReturn(tr.getMockBasicDetails());
        when(popupDetailsParser.parse(any(Element.class))).thenReturn(tr.getMockPopupDetails());
        when(stageDetailsParser.parse(any(Element.class))).thenReturn(tr.getMockStageDetails());
        when(urlMonthService.compileUrlsForRemainingYearMonths()).thenReturn(tr.mockAugust2018Urls());
        parsingLoop.setUrlPopupWithPlaceholder(tr.mockPopupUrl());
    }

    /**
     * The aim of this test is to ensure that the Loop through the HTML works.
     * This has nothing to do with the actual data that is returned, as this is dealt with in the individual Parser Tests.
     */
    @Test public void testStartParseLoopLocal() {

        parsingLoop.setLocalPopupFile(tr.localPopupFile());
        parsingLoop.setLocalStagesFile(tr.localStagesFile());

        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop(tr.localBasicFile());

        int expectedSize = tr.localBasicFileExpectedSize();
        int actualSize = roadRaces.size();
        String failMessage = String.format("Size: Actual: %d, Expected: %d.", actualSize, expectedSize);

        assertTrue(failMessage, actualSize == expectedSize);
    }

    /**
     * The aim of this test is to ensure that the Loop through the Remote HTML works.
     * This has nothing to do with the actual data that is returned, as this is dealt with in the individual Parser Tests.
     */
    //@Ignore // Ignoring until app is able to parse from remote.
    @Test public void testStartParseLoopRemote() {

        List<RoadRaceEvent> roadRaces = parsingLoop.startParseLoop("");

        int expectedSize = tr.localBasicFileExpectedSize();
        int actualSize = roadRaces.size();
        String failMessage = String.format("Size: Actual: %d, Expected: %d.", actualSize, expectedSize);

        assertTrue(failMessage, actualSize == expectedSize);
    }

}
