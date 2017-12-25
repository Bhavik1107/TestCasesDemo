package com.unittestdemo.utils;

import android.support.annotation.Nullable;

/**
 * Created by Lalit on 26-May-17.
 * This class contains the methods to validate the inputs.
 */

public class Validator {
    @SuppressWarnings("unused")
    private static final String TAG = "Validator";
    //Regex patterns
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //Min max lengths
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MAX_PASSWORD_LENGTH = 30;

    /**
     * This method is used to check whether email is valid or not.
     *
     * @param emailToCheck Email string to check.
     * @return true if the email is valid.
     */
    public static boolean isEmailValid(@Nullable String emailToCheck) {
        if (emailToCheck == null) return false;
        emailToCheck = emailToCheck.trim();
        return emailToCheck.matches(EMAIL_PATTERN);
    }

    /**
     * This method is used to check whether password is of valid length.
     *
     * @param passwordToCheck Password to check
     * @return true if length matches.
     */
    public static boolean isPasswordValid(@Nullable String passwordToCheck) {
        if (passwordToCheck == null) return false;
        passwordToCheck = passwordToCheck.trim();
        return passwordToCheck.length() >= MIN_PASSWORD_LENGTH && passwordToCheck.length() <= MAX_PASSWORD_LENGTH;
    }

    public static boolean isValidNumber(String phoneNumber) {
        return phoneNumber.length() == 10;
    }

}