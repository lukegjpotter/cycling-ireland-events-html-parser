package com.lukegjpotter.spring.application.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RaceTypesHolderTest {
    // TODO Add more tests here.
    @Test
    public void testEqualsOtherObject() {
        assertFalse(new RaceTypesHolder().equals(new Date()));
    }

}
