package com.lukegjpotter.spring.application.parse.y2018;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.testresources.PopupDetailsParserTestResources;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PopupDetailsParserTest {

    @Autowired
    private PopupDetailsParser popupDetailsParser;
    @Autowired
    private UtilsService utils;
    @Autowired
    private PopupDetailsParserTestResources tr;

    @Before
    public void setUp() {
    }

    @Test public void testParse() {

        PopupDetails actual = popupDetailsParser.parse(tr.popupElement());
        PopupDetails expected = tr.popupDetails();

        String failStartDate = String.format("StartDate: Expected: %s, Actual: %s", expected.getStartDate(), actual.getStartDate());
        String failProvince = String.format("Province: Expected: %s, Actual: %s", expected.getProvince(), actual.getProvince());
        String failCategory = String.format("Category: Expected: %s, Actual: %s", expected.getCategory(), actual.getCategory());
        String failPromotingClub = String.format("PromotingClub: Expected: %s, Actual: %s", expected.getPromotingClub(), actual.getPromotingClub());
        String failOrganiserName = String.format("OrganiserName: Expected: %s, Actual: %s", expected.getOrganiserName(), actual.getOrganiserName());
        String failOrganiserEmail = String.format("OrganiserEmail: Expected: %s, Actual: %s", expected.getOrganiserEmail(), actual.getOrganiserEmail());
        String failOrganiserPhoneNumber = String.format("OrganiserPhoneNumber: Expected: %s, Actual: %s", expected.getOrganiserPhoneNumber(), actual.getOrganiserPhoneNumber());
        String failMoreInfoUrl = String.format("MoreInfoUrl: Expected: %s, Actual: %s", expected.getMoreInfoUrl(), actual.getMoreInfoUrl());

        assertTrue(failStartDate, actual.getStartDate().equals(expected.getStartDate()));
        assertTrue(failProvince, actual.getProvince().equals(expected.getProvince()));
        assertTrue(failCategory, actual.getCategory().equals(expected.getCategory()));
        assertTrue(failPromotingClub, actual.getPromotingClub().equals(expected.getPromotingClub()));
        assertTrue(failOrganiserName, actual.getOrganiserName().equals(expected.getOrganiserName()));
        assertTrue(failOrganiserEmail, actual.getOrganiserEmail().equals(expected.getOrganiserEmail()));
        assertTrue(failOrganiserPhoneNumber, actual.getOrganiserPhoneNumber().equals(expected.getOrganiserPhoneNumber()));
        assertTrue(failMoreInfoUrl, actual.getMoreInfoUrl().equals(expected.getMoreInfoUrl()));
    }

    @Test public void testParseNoOrganiserEmail() {

        PopupDetails popup = popupDetailsParser.parse(tr.popupElementNoOrganiserEmail());

        assertTrue("Organiser Name", popup.getOrganiserName().equals("Alan Surname"));
        assertTrue("Organiser Email", popup.getOrganiserEmail().equals(""));
        assertTrue("Phone Number", popup.getOrganiserPhoneNumber().equals("+353872727811"));
    }
}
