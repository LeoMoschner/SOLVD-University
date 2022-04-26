package com.solvd.university.services;

import com.solvd.university.customExceptions.*;

public class CheckInfo {

    protected String checkSelections(String inputSelection, int possibleSelections) {

        if (inputSelection.isEmpty()) {
            throw new NullException();

        } else {
            if (inputSelection.matches("[+-]?\\d*")) {

                if (Integer.parseInt(inputSelection) > 0 && Integer.parseInt(inputSelection) <= possibleSelections) {
                    return inputSelection;

                } else {
                    throw new NumberOutOfRangeException(1, possibleSelections);
                }
            } else {
                throw new NotANumberException();
            }
        }
    }

    public static String checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            throw new NullException();

        } else {
            if (phoneNumber.matches("\\d*")) {
                return phoneNumber;

            } else {
                throw new NotANumberException();
            }
        }
    }

    public static String checkName(String name) {
        if (name.isEmpty()) {
            throw new NamesException("Null. You must enter a valid name");

        } else {

            if (name.matches("[A-Z]+,\\s[A-Z][a-z]+")) {
                return name;

            } else {
                throw new NamesException("Invalid characters for names. You must enter a valid Name");
            }
        }
    }

    public static String checkEmail(String email) {

        if (email.isEmpty()) {
            throw new NullException();
        } else {
            if (email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {
                return email;
            } else {
                throw new EmailException();
            }
        }

    }

    public static int checkAge(String age) {

        if (age.isEmpty()) {
            throw new NullException();
        } else {
            if (age.matches("\\d*")) {
                if (Integer.parseInt(age) > 17 && Integer.parseInt(age) <= 100) {
                    return Integer.parseInt(age);

                } else {
                    //String is a number but is not between 18-100
                    throw new NumberOutOfRangeException(18, 100);

                }
            } else {
                //String is not a number
                throw new NotANumberException();
            }
        }
    }
}

