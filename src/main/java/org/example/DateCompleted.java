package org.example;

public class DateCompleted implements DateADT{

    private int year;
    private int month;
    private int day;
    private int totalDays ;
    @Override
    public void setDate(int y, int m, int d) throws InvalidDateException {
        if (y <= 0 || m > 12 || m <= 0 || d <= 0 || d > 30)
            throw new InvalidDateException("Input date is not valid!");

        this.year = y;
        this.month = m;
        this.day = d;
        totalDays = (year * 360) + (month * 30) + day;
    }

    @Override
    public int compareDate(DateADT date) {
        String[] dateString = date.toISOFormat().split("-");
        int y = Integer.parseInt(dateString[0]);
        int m = Integer.parseInt(dateString[1]);
        int d = Integer.parseInt(dateString[2]);

        int totDays = (y * 360) + (m * 30) + d;
        return totalDays - totDays;
    }

    @Override
    public String toISOFormat() {
        return year + "-" + month + "-" + day ;
    }

    @Override
    public void advance(int days) {
        int totalDays = (year * 360) + (month * 30) + day;
        totalDays += days;
        year = (int) Math.floor(totalDays / 360);
        month = (int) Math.floor((totalDays - year * 360) / 30);
        day = totalDays - year * 360 - month * 30;
    }

    @Override
    public void retreat(int days) {
        int totalDays = (year * 360) + (month * 30) + day;
        totalDays -= days;
        year = (int) Math.floor(totalDays / 360);
        month = (int) Math.floor((totalDays - year * 360) / 30);
        day = totalDays - year * 360 - month * 30;
    }
}
