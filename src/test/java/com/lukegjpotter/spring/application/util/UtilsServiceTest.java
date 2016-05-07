package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, UtilsService.class })
public class UtilsServiceTest {

    @Autowired UtilsService utilsService;
    
    List<String> elements = Arrays.asList("one", "two", "three");

    @Test(expected = NullPointerException.class)
    public void testConvertMMMMDDYYYYToDate_NPECheck() {
        Date npeDate =  utilsService.convertMMMMDDYYYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDDMMMYYToDate_NPECheck() {
        Date npeDate =  utilsService.convertDDMMMYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDDMMYYYYToDate_NPECheck() {
        Date npeDate =  utilsService.convertDDMMYYYYToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }
    
    @Test public void testIsListElementInStringElementsMatch() {
        String string = "one,two,three";
        assertTrue(utilsService.isListElementInString(string, elements));
    }
    
    @Test public void testIsListElementInStringElementsDontMatch() {
        String string = "horse";
        assertFalse(utilsService.isListElementInString(string, elements));
    }
    
    @Test public void testFormatLocationEmptyString() {
        String expected = "";
        String actual = utilsService.formatLocation("");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatLocationCommaSpace() {
        String expected = "";
        String actual = utilsService.formatLocation(", ");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatLocationStandardLocation() {
        String expected = "Rugby Club, Ballyhaunis";
        String actual = utilsService.formatLocation("Rugby Club, Ballyhaunis");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatLocationLeadingComma() {
        String expected = "Castlebar";
        String actual = utilsService.formatLocation(", Castlebar");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberEmptyString() {
        String expected = "";
        String actual = utilsService.formatPhoneNumber("");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberWithSpace() {
        String expected = "+353879764249";
        String actual = utilsService.formatPhoneNumber("+353 879764249");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberNorthernIreland() {
        String expected = "+447747444241";
        String actual = utilsService.formatPhoneNumber("+447747444241");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberDoubleNorthernIrelandPrefix() {
        String expected = "+447747444241";
        String actual = utilsService.formatPhoneNumber("+44+44 7747444241");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberNiAndRoiAndZeroPrefix() {
        String expected = "+353878037543";
        String actual = utilsService.formatPhoneNumber("+44+353 087 8037543");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberDoubleNorthernIrelandAndZeroPrefix() {
        String expected = "+447803178916";
        String actual = utilsService.formatPhoneNumber("+44+44 078 0317 8916");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberNorthernIrelandAndZeroPrefix() {
        String expected = "+447742118970";
        String actual = utilsService.formatPhoneNumber("+4407742118970");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberNorthernIrelandPrefixForIrelandNumber() {
        String expected = "+353857392915";
        String actual = utilsService.formatPhoneNumber("+44+353 857392915");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberDoubleIrelandPrefix() {
        String expected = "+353876744400";
        String actual = utilsService.formatPhoneNumber("+353+353 876744400");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberDoubleIrelandAndZeroPrefix() {
        String expected = "+353876744400";
        String actual = utilsService.formatPhoneNumber("+353+353 087 6744 400");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberDoubleIrelandNoSecondPlusSignPrefix() {
        String expected = "+353876744400";
        String actual = utilsService.formatPhoneNumber("+353353876744400");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberIrelandWithZeroPrefix() {
        String expected = "+353949022966";
        String actual = utilsService.formatPhoneNumber("+353 0949022966");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberIrelandPrefixForNorthernIrelandNumber() {
        String expected = "+447976133386";
        String actual = utilsService.formatPhoneNumber("+353+44 7976133386");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberIrelandPrefixWithMisplacedPlus() {
        String expected = "+353879281513";
        String actual = utilsService.formatPhoneNumber("+353+879281513");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberIrelandPrefixWithHyphen() {
        String expected = "+353871375036";
        String actual = utilsService.formatPhoneNumber("+353+353 087-1375036");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
    
    @Test public void testFormatPhoneNumberNorthernIrelandPrefixWithZero() {
        String expected = "+447714696789";
        String actual = utilsService.formatPhoneNumber("07714696789");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

}
