package com.lukegjpotter.spring.application.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lukegjpotter.spring.application.CyclingIrelandEventsHtmlScraperApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CyclingIrelandEventsHtmlScraperApplication.class, NullCheckUtilsService.class })
public class NullCheckUtilsServiceTest {
    
    @Autowired NullCheckUtilsService nullCheckUtilsService;

    @Test public void testTimeNullCheckNull() {
        assertTrue(nullCheckUtilsService.timeNullCheck("").equals(""));
    }
    
    @Test public void testTimeNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.timeNullCheck(" 12.34 ").equals("12:34"));
    }
    
    @Test public void testStringNullCheckNull() {
        assertTrue(nullCheckUtilsService.stringNullCheck("").equals(""));
    }
    
    @Test public void testStringNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.stringNullCheck(" Jon Snow ").equals("Jon Snow"));
    }
    
    @Test public void testDoubleNullCheckNull() {
        assertTrue(nullCheckUtilsService.doubleNullCheck("").equals(new Double(0)));
    }
    
    @Test public void testDoubleNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.doubleNullCheck(" 6 ").equals(new Double(6)));
    }
    
    @Test public void testIntegerNullCheckNull() {
        assertTrue(nullCheckUtilsService.integerNullCheck("").equals(new Integer(0)));
    }
    
    @Test public void testIntegerNullCheckNotNull() {
        assertTrue(nullCheckUtilsService.integerNullCheck(" 6 ").equals(new Integer(6)));
    }
}
