package org.example;
/**
* DateADT.java
*
* @author Ahmad Heshmati , Syed Jawad Raza Baquar
* @version 1.0
*
* Class Definition: DateADT interface represents the public contract for the implementation of Date class. Dates can be in the past, present, and future.
* The dates are constructed from year number, month number, and day number.
* Dates can be compared, rendered in ISO format, and advanced/retreated by a given number of days.
*/
public interface DateADT {

    /**
     * Mutator method to set the value of the date
     *
     * Precondition: Input year, month and days values are valid
     *
     * Postcondition: The date object is crated with the specified year, month and day values
     *
     * @param y The year
     * @param m The month
     * @param d The day
     *
     * @exception InvalidDateException if the input date is not valid.
     */
    public void setDate(int y, int m, int d) throws InvalidDateException;

    /**
     * Transformer method to compare a date object with another date object
     *
     * Precondition: A valid date object exists and another date object is passed
     *
     * Postcondition: The difference in total days between the current date object and the input date object
     *
     * @param date The DateADT object
     *
     * @return The difference in total days as an integer value
     */
    public int compareDate(DateADT date);

    /**
     * Transformer method to render the date in ISO format
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: The date in ISO format (yyyy-mm-dd)
     *
     * @return The date in ISO format as a string
     */
    public String toISOFormat();

    /**
     * Transformer method to advance a date by the given number of days
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: The new date after advancing by the specified number of days
     *
     * @param days The number of days to advance the given date
     *
     * @throws InvalidDateException If there is an error in creating the new date object after advancing by the given number of days
     *
     * @return The new date in ISO format as a string
     */
    public String advance(int days);

    /**
     * Transformer method to retreat a date by the given number of days
     *
     * Precondition: A valid date object exists
     *
     * Postcondition: The new date after retreating by the specified number of days
     *
     * @param days The number of days to retreat the given date
     *
     * @throws InvalidDateException If there is an error in creating the new date object after retreating by the given number of days
     *
     * @return The new date in ISO format as a string
     */
    public String retreat(int days);

}
