package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class UtilsTest {

    @Test(expected = NullPointerException.class)
    public void testConvertStringToDateString_NPECheck() {
        Date npeDate = Utils.convertStringToDate("Contiune-Commit-Streak");
        assertTrue(npeDate.equals(new Date()));
    }

    @Test(expected = NullPointerException.class)
    public void testConvertStringToDateStringString_NPECheck() {
        Date npeDate = Utils.convertStringToDate("Contiune-Commit-Streak", Constants.DATE_FORMAT_DDMMYYYY);
        assertTrue(npeDate.equals(new Date()));
    }

}
