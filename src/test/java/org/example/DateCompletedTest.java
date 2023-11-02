/**
 * ANNOTATIONS:
 * @Test -  The annotation @Test identifies that a method is a test method.
 * @Ignore - Will ignore the test method. This is useful when the underlying code has been changed and
 * 		the test case has not yet been adapted. Or if the execution time of this test is too long to be included.
 * @Test(expected=Exception.class) - Fails, if the method does not throw the named exception.
 * @Test(timeout=100) - Fails, if the method takes longer than 100 milliseconds.
 *
 * ASSERTS: [] = optional message to display
 * fail([String]) - Let the method fail. Might be used to check that a certain part of the code is not reached.
 * 		Or to have failing test before the test code is implemented.
 * assertTrue(boolean) - Will always be true/false. Can be used to predefine a test result,
 * 		if the test is not yet implemented.
 * assertTrue([String], boolean condition) - Checks that the boolean condition is true.
 * assertsEquals([String], expected, actual) - Tests that two values are the same.
 * 		Note: for arrays the reference is checked not the content of the arrays.
 * assertsEquals([String], expected, actual, tolerance) - Test that float or double values match.
 * 		The tolerance is the number of decimals which must be the same.
 * assertNull([String], object) - Checks that the object is null.
 * assertNotNull([String], object) - Checks that the object is not null.
 * assertSame([String], expected, actual) - Checks that both variables refer to the same object.
 * assertNotSame([String], expected, actual) - Checks that both variables refer to different objects.
 *
 */
package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * DateCompletedTest.java
 *
 * @author Ahmad Heshmati , Syed Jawad Raza Baquar
 * @version 1.0
 *
 * Class Definition: DateCompletedTest is a test class to perform Unit testing on the methods of the DateCompleted class
 */
public class DateCompletedTest {

        // Test objects
        DateCompleted date1;
        DateCompleted date2;

     /**
     * @Before - Setup method executed before each test.
     * Initializes DateCompleted objects for testing
     * @throws java.lang.Exception if an error occurs during setup
     */
    @Before
    public void setUp() throws Exception {
        date1 = new DateCompleted(2023,11,20);
        date2 = new DateCompleted(2023,11,18);
    }

     /**
     * @After - Tear down method executed after each test.
     * Cleans up resources after testing
     * @throws java.lang.Exception if an error occurs during teardown
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for setDate
     * throws InvalidDateException for invalid inputs
     */
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

    /**
     * Test method for setDate
     * throws InvalidDateException for invalid inputs
     */
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

    /**
     * Test method for compareDate
     */
    @Test
    public void compareDate() {
        int expectedDifference = 2;
        int actualDifference = date1.compareDate(date2);
        assertEquals("This test failed", expectedDifference, actualDifference);
        int expectedDifference2 = 0;
        int actualDifference2 = date1.compareDate(date1);
        assertEquals("This test failed", expectedDifference2, actualDifference2);

    }

    /**
     * Test method for toISOFormat
     */
    @Test
    public void toISOFormat() {
        String expected = "2023-11-20";
        String actual = date1.toISOFormat();
        assertEquals(expected,actual);
    }

    /**
     * Test method for advance
     */
    @Test
    public void advance() {
        String expected = "2023-12-5";
        String actual = date1.advance(15);
        assertEquals(expected,actual);
        String expected2 = "2024-11-19";
        String actual2 = date1.advance(365);
        assertEquals(expected2,actual2);
    }

    /**
     * Test method for retreat
     */
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