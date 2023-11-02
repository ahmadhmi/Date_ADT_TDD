package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidDateException {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a day: ");
        String input = scanner.next();

        int year = 2010;
        int month = 1;
        int day;

        switch (input.toLowerCase()){
            case "friday":
                day = 1;
                break;
            case "saturday":
                day = 2;
                break;
            case "sunday":
                day = 3;
                break;
            case "monday":
                day = 4;
                break;
            case "tuesday":
                day = 5;
                break;
            case "wednesday":
                day = 6;
                break;
            case "thursday":
                day = 7;
                break;
            default:
                throw new InvalidDateException();
        }

        DateCompleted date  = new DateCompleted(year,month,day);

        int y = 2010;
        int counter = 0;

        while(y < 2011){
            String newDate = date.advance(counter);

            String[] token = newDate.split("-");
            y = Integer.parseInt(token[0]);
            if (y > 2010)
                break;
            counter += 7;
            System.out.println(newDate + " " + input.toUpperCase());
        }
    }
}