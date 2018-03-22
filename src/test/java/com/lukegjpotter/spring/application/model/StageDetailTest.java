package com.lukegjpotter.spring.application.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StageDetailTest {

    private StageDetail stage;

    @Before
    public void setUp() {
        stage = new StageDetail();
        stage.setStageName("Stage 1");
        stage.setCategory("A4");
        stage.setKilometers(50D);
    }

    @Test public void testToString() {
        String expected = "Stage 1: A4 - 50.0km";
        String actual = stage.toString();

        String failMessage = String.format("Expected: %s\nActual: %s", expected, actual);

        assertTrue(failMessage, expected.equals(actual));
    }

    @Test public void testEqualsOtherObject() {
        assertFalse(stage.equals(new Date()));
    }

}
