package model.exceptions;

/*
The exception is actual while specified phone number
 is missed or has incorrect format
 */

public class NotValidPhoneException extends Exception {

    public NotValidPhoneException(String message) {
        super(message);
    }
}
