package util;

import model.exceptions.NoContactDataException;

import java.util.regex.Pattern;

public class Validator {

    private static String emailTemplate = "^[a-zA-Z0-9._%+-]++@[a-zA-Z0-9-]{2,}\\.[a-zA-Z]{2,}+$";
    private static String phoneTemplate = "^\\+375(29|33|44|25|17)\\d{7}$";

    public static Boolean isEmailValid(String email) {
        return Pattern.matches(emailTemplate, email);
    }

    public static Boolean isPhoneValid(String phone) {
        return Pattern.matches(phoneTemplate, phone);
    }

    public static void checkContactData(String email, String phone) throws NoContactDataException {
        if (!isEmailValid(email) && !isPhoneValid(phone)) {
            throw new NoContactDataException("Contact data is missed or invalid.");
        }
    }

}
