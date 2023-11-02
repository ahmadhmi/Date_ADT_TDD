package org.example;

/**
 * InvalidDateException.java
 *
 * @author Ahmad Heshmati , Syed Jawad Raza Baquar
 * @version 1.0
 *
 * Class Definition: Exception class to throw an exception when the date is not valid
 */
public class InvalidDateException extends Exception {

    //Constructor for InvalidDateException with no specified detailed message
    public InvalidDateException(){
        super();
    }

    //Constructor for InvalidDateException with the specified detailed message
    public InvalidDateException(String message)
    {
        super(message);
    }
}
