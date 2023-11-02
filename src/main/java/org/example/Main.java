package org.example;

import java.util.Scanner;

/**
 * Main.java
 *
 * @author Ahmad Heshmati , Syed Jawad Raza Baquar
 * @version 1.0
 *
 * Class Definition: Main class to get the input from the user and run our program
 */
public class Main {
    public static void main(String[] args) throws InvalidDateException {

        //Getting the input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a day: ");
        String input = scanner.next();

        int year = 2010;
        int month = 1;
        int day;

        // Map the user input to corresponding day number
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

        // Initializing the date object based on the user input
        DateCompleted date  = new DateCompleted(year,month,day);

        int y = 2010;
        int counter = 0;

        // Printing every single date in 2010 which has the same day as the user entered
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