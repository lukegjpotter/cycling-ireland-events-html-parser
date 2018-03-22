package com.lukegjpotter.spring.application.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NullCheckUtilsServiceTest {

    @Autowired
    private NullCheckUtilsService nullCheckUtilsService;

    @Test public void testTimeNullCheckNull() {
        assertTrue(nullCheckUtilsService.timeNullCheck("").equals(""));
    }

    @Test public void testTimeNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.timeNullCheck(" 12.34 ").equals("12:34"));
    }

    @Test public void testTimeNullCheckThreeCharacters() {
        assertTrue(nullCheckUtilsService.timeNullCheck("9:3").equals("09:30"));
    }

    @Test public void testStringNullCheckNull() {
        assertTrue(nullCheckUtilsService.stringNullCheck("").equals(""));
    }

    @Test public void testStringNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.stringNullCheck(" Jon Snow ").equals("Jon Snow"));
    }

    @Test public void testDoubleNullCheckNull() {
        assertTrue(nullCheckUtilsService.doubleNullCheck("").equals((double) 0));
    }

    @Test public void testDoubleNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.doubleNullCheck(" 6 ").equals(6d));
    }

    @Test public void testIntegerNullCheckNull() {
        assertTrue(nullCheckUtilsService.integerNullCheck("").equals(0));
    }

    @Test public void testIntegerNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.integerNullCheck(" 6 ").equals(6));
    }
}
