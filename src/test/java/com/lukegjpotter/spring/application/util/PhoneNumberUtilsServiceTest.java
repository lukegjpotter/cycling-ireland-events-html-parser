package com.lukegjpotter.spring.application.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneNumberUtilsServiceTest {

    @Autowired
    private PhoneNumberUtilsService phoneNumberUtilsService;

    @Test public void testFormatPhoneNumberEmptyString() {
        String expected = "";
        String actual = phoneNumberUtilsService.formatPhoneNumber("");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberWithSpace() {
        String expected = "+353879764249";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353 879764249");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberNorthernIreland() {
        String expected = "+447747444241";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+447747444241");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberDoubleNorthernIrelandPrefix() {
        String expected = "+447747444241";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+44+44 7747444241");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberNiAndRoiAndZeroPrefix() {
        String expected = "+353878037543";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+44+353 087 8037543");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberDoubleNorthernIrelandAndZeroPrefix() {
        String expected = "+447803178916";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+44+44 078 0317 8916");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberNorthernIrelandAndZeroPrefix() {
        String expected = "+447742118970";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+4407742118970");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberNorthernIrelandPrefixForIrelandNumber() {
        String expected = "+353857392915";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+44+353 857392915");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberDoubleIrelandPrefix() {
        String expected = "+353876744400";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353+353 876744400");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberDoubleIrelandAndZeroPrefix() {
        String expected = "+353876744400";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353+353 087 6744 400");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberDoubleIrelandNoSecondPlusSignPrefix() {
        String expected = "+353876744400";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353353876744400");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberIrelandWithZeroPrefix() {
        String expected = "+353949022966";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353 0949022966");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberIrelandPrefixForNorthernIrelandNumber() {
        String expected = "+447976133386";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353+44 7976133386");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberIrelandPrefixWithMisplacedPlus() {
        String expected = "+353879281513";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353+879281513");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberIrelandPrefixWithHyphen() {
        String expected = "+353871375036";
        String actual = phoneNumberUtilsService.formatPhoneNumber("+353+353 087-1375036");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }

    @Test public void testFormatPhoneNumberNorthernIrelandPrefixWithZero() {
        String expected = "+447714696789";
        String actual = phoneNumberUtilsService.formatPhoneNumber("07714696789");
        assertTrue("Expected: " + expected + ". Actual: " + actual, expected.equals(actual));
    }
}
