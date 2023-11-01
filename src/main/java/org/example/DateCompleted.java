package org.example;

import java.util.HashMap;

public class DateCompleted implements DateADT{


    public HashMap<Integer, Integer> Monthmap = new HashMap<>();

    private int year;

    private int month;
    private int day;


    private int totalDays = 0 ;

    public HashMap<Integer, Integer> daysInMonths = new HashMap<>();


    public DateCompleted(int y, int m, int d) throws InvalidDateException {
        populateMap();
        setDate(y,m,d);
        totalDays = getTotalDays();
    }


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

    private DateCompleted daysToDate(int totalDays) throws InvalidDateException {
        int y = 1;
        int m = 1;
        int d = 1;
        while(true){
            int daysInYear = isLeapYear(y) ? 366 : 365;
            if (totalDays >= daysInYear){
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

    public int getTotalDays(){
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
