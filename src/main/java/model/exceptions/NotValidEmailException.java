package model.exceptions;

/*
The exception is actual while specified email
 is missed or has incorrect format
 */

public class NotValidEmailException extends Exception {

    public NotValidEmailException(String message) {
        super(message);
    }
}
