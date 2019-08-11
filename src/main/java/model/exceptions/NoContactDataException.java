package model.exceptions;

/*
The exception is actual while specified contact data
(email and phone) is missed or has incorrect format
 */
public class NoContactDataException extends Exception {

    public NoContactDataException(String message) {
        super(message);
    }
}
