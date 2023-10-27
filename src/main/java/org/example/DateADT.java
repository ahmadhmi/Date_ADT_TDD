package org.example;
/*
* DateADT.java
*
* @author Ahmad Heshmati , Syed Jawad Raza Baquar
* @version 1.0
*
*
* Class Definition: Date ADT represents dates in past, present, and future.
* The dates are constructed from year number, month number, and day number.
* Dates can be compared, rendered in ISO format, and advanced/retreated by a given number of days.
*
* */
public interface DateADT {

    public void setDate(int y, int m, int d) throws InvalidDateException;
    public int compareDate(DateADT date);
    public String toISOFormat();
    public void advance(int days);
    public void retreat(int days);

}
