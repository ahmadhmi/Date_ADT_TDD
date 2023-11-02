package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateCompletedTest {

        DateCompleted date1;
        DateCompleted date2;
    @Before
    public void setUp() throws Exception {
        date1 = new DateCompleted(2023,11,20);
        date2 = new DateCompleted(2023,11,18);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setDate1(){

        try {
            date1.setDate(2025, 13, 10);
            fail();
        }
        catch (InvalidDateException e){
            assertTrue(true);
        }
        try {
            date1.setDate(2025, 12, 32);
            fail();
        }
        catch (InvalidDateException e){
            assertTrue(true);
        }
        try {
            date1.setDate(0, 12, 15);
            fail();
        }
        catch (InvalidDateException e){
            assertTrue(true);
        }
        try {
            date1.setDate(4, 2, 30);
            fail();
        }
        catch (InvalidDateException e){
            assertTrue(true);
        }

    }
    @Test
    public void setDate2() throws InvalidDateException {
        date1.setDate(2024,11,10);
        int expectedYear = 2024;
        int expectedMonth = 11;
        int expectedDay = 10;
        assertEquals(expectedYear, date1.getYear());
        assertEquals(expectedMonth, date1.getMonth());
        assertEquals(expectedDay, date1.getDay());
    }

    @Test
    public void compareDate() {
        int expectedDifference = 2;
        int actualDifference = date1.compareDate(date2);
        assertEquals("This test failed", expectedDifference, actualDifference);
        int expectedDifference2 = 0;
        int actualDifference2 = date1.compareDate(date1);
        assertEquals("This test failed", expectedDifference2, actualDifference2);

    }

    @Test
    public void toISOFormat() {
        String expected = "2023-11-20";
        String actual = date1.toISOFormat();
        assertEquals(expected,actual);
    }

    @Test
    public void advance() {
        String expected = "2023-12-5";
        String actual = date1.advance(15);
        assertEquals(expected,actual);
        String expected2 = "2024-11-19";
        String actual2 = date1.advance(365);
        assertEquals(expected2,actual2);
    }

    @Test
    public void retreat() {
        String expected = "2023-11-5";
        String actual = date1.retreat(15);
        assertEquals(expected,actual);
        String expected2 = "2022-11-20";
        String actual2 = date1.retreat(365);
        assertEquals(expected2,actual2);
    }
}