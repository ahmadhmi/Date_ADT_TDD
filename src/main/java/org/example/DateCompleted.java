package org.example;

import java.util.HashMap;

/**
 * DateCompleted.java
 *
 * @author Ahmad Heshmati , Syed Jawad Raza Baquar
 * @version 1.0
 *
 * Class Definition: DateCompleted class is the implementation of the DateADT interface.
 * It was needed to create some additional methods in order to efficiently implement all the methods of the DateADT interface.
 */
public class DateCompleted implements DateADT{

    // Fields
    private int year;
    private int month;
    private int day;

    // Attributes
    private int totalDays = 0 ;
    public HashMap<Integer, Integer> daysInMonths = new HashMap<>();

    /**
     * Constructor as a mutator method to initialize the DateCompleted objects
     *
     * Precondition: Input year, month and days values are valid
     *
     * Postcondition:  DateCompleted object is initialized with the specified year, month and day values.
     *
     * @param y The year
     * @param m The month
     * @param d The day
     *
     * @throws InvalidDateException if the input year, month and day values are not valid
     */
    public DateCompleted(int y, int m, int d) throws InvalidDateException {
        populateMap();
        setDate(y,m,d);
        totalDays = setTotalDays();
    }

    /**
     * Accessor method to return the year value
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: The current year value of the date object
     *
     * @return The current year value as an integer
     */
    public int getYear() {
        return year;
    }

    /**
     * Accessor method to return the month value
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: The current month value of the date object
     *
     * @return The current month value as an integer
     */
    public int getMonth() {
        return month;
    }

    /**
     * Accessor method to return the day value
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: The current day value of the date object
     *
     * @return The current day value as an integer
     */
    public int getDay() {
        return day;
    }


    /**
     * Mutator method to populate the hash map with days value for each month
     *
     * Precondition: none
     *
     * Postcondition: The populated hash map
     */
    private void populateMap(){
        daysInMonths.put(1,31);
        daysInMonths.put(2,28);
        daysInMonths.put(3,31);
        daysInMonths.put(4,30);
        daysInMonths.put(5,31);
        daysInMonths.put(6,30);
        daysInMonths.put(7,31);
        daysInMonths.put(8,31);
        daysInMonths.put(9,30);
        daysInMonths.put(10,31);
        daysInMonths.put(11,30);
        daysInMonths.put(12,31);
    }
    @Override
    public void setDate(int y, int m, int d) throws InvalidDateException {
        if (y <= 0 || m > 12 || m <= 0 || d <= 0 || d > 31)
            throw new InvalidDateException("Input date is not valid!");

        if (isLeapYear(y))
            if (m ==2 && d > 29)
                throw new InvalidDateException("Input date is not valid!");

        if (daysInMonths.get(m) < d)
            throw new InvalidDateException("Input date is not valid!");

        this.year = y;
        this.month = m;
        this.day = d;
    }


    @Override
    public int compareDate(DateADT date) {
        DateCompleted input = (DateCompleted) date;
        return this.totalDays - input.getTotalDays();
    }

    @Override
    public String toISOFormat() {
        return year + "-" + month + "-" + day ;
    }

    @Override
    public String advance(int days) {

        try{
            int newTotalDays = this.totalDays + days;
            DateCompleted newInstance = daysToDate(newTotalDays);
            return newInstance.toISOFormat();

        }catch (InvalidDateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String retreat(int days) {
        try{
            int newTotalDays = this.totalDays - days;
            if (newTotalDays < 0)
                throw new InvalidDateException("The date can not be prior to the beginning of the world!!!");
            DateCompleted newInstance = daysToDate(newTotalDays);
            return newInstance.toISOFormat();

        }catch (InvalidDateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    /**
     * Transformer method to convert the total number of days into a valid date object
     *
     * Precondition: none
     *
     * Postcondition: The date object for the total number of days
     *
     * @param totalDays The total number of days
     *
     * @throws InvalidDateException If there is an error in creating the date object from the total number of days
     *
     * @return The date object
     */
    private DateCompleted daysToDate(int totalDays) throws InvalidDateException {
        int y = 1;
        int m = 1;
        int d = 1;
        while(true){
            int daysInYear = isLeapYear(y) ? 366 : 365;
            if (totalDays > daysInYear){
                totalDays -= daysInYear;
                y++;
            }
            else
                break;
        }

        int[] daysInMonthArray = new int[12];

        for (int i = 0; i < daysInMonthArray.length; i++){
            if (isLeapYear(y) && i ==1){
                daysInMonthArray[i] = 29;
                continue;
            }
            daysInMonthArray[i] = this.daysInMonths.get(i+1);
        }
        while (daysInMonthArray[m-1] < totalDays){
            totalDays -= daysInMonthArray[m-1];
            m++;
        }
        if (totalDays > 0)
            d = totalDays;

        return new DateCompleted(y,m,d);
    }

    /**
     * Transformer method to convert a given date into total number of days
     *
     * Precondition: Input year, month and days values are valid
     *
     * Postcondition: Total number of days for a given date
     *
     * @return Total number of days for a given date as an Integer value
     */
    private int setTotalDays(){
        for (int i = 1 ; i < year; i++){
            if (isLeapYear(i))
                totalDays += 366;

            else
                totalDays += 365;
        }
        for (int i = 1; i < month; i++){
            if (i == 2){
                if (isLeapYear(year))
                    totalDays += 29;
                else
                    totalDays += 28;
                continue;
            }
            totalDays += daysInMonths.get(i);
        }
        totalDays += day;
        return totalDays;
    }

    /**
     * Accessor method to return the  total number of days
     *
     * Precondition: total number of days value exists
     *
     * Postcondition: The value of the total number of days
     *
     * @return The total number of days value as an integer
     */
    public int getTotalDays(){
        return totalDays;
    }

    /**
     * Transformer method to check if a given year is a leap year or not
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: Whether a given year is a leap year or not
     *
     * @param year The year
     *
     * @return Whether a given year is a leap year or not as a boolean value
     */
    private boolean isLeapYear(int year){
        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0)
                    return true;
                else return false;
            }
            else
                return true;
        }
        else return false;
    }
}
