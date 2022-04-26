package com.solvd.university.customExceptions;

public class NumberOutOfRangeException extends RuntimeException {

    private static String msg = "Number out of range. You must enter a number between ";

    public NumberOutOfRangeException(int min, int max) {

        msg = msg + min + " and " + max;

    }

    @Override
    public String getMessage() {

        return msg;
    }
}
