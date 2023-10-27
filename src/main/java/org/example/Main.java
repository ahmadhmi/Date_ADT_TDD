package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateCompleted test = new DateCompleted();
        try
        {
            test.setDate(2023, 10, 27);
            System.out.println(test.toISOFormat());
            test.advance(2);
            System.out.println(test.toISOFormat());
            test.retreat(2);
            System.out.println(test.toISOFormat());
            DateCompleted date2 = new DateCompleted();
            date2.setDate(2023, 10, 29);
            System.out.println(test.compareDate(date2));

            Scanner scanner = new Scanner(System.in);
            String dayInput = scanner.next();


        }
        catch (InvalidDateException e){
            System.out.println(e.getMessage());
        }
    }
}