package com.lukegjpotter.spring.application.parse;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParserFactoryTest {

    @Test
    public void testGetPageOneParser() {
        assertTrue(ParserFactory.getPageOneParser("") instanceof PageOneParser);
    }

    @Test
    public void testGetPageTwoParser() {
        assertTrue(ParserFactory.getPageTwoParser("") instanceof PageTwoParser);
    }
}
