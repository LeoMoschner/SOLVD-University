package com.solvd.university.customExceptions;

public class EmailException extends RuntimeException {

    private static final String msg = "Not valid e-mail. Please enter a correct e-mail in the following format: \n something@something";

    @Override
    public String getMessage() {
        return msg;
    }
}
