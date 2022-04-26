package com.solvd.university.customExceptions;

public class NotANumberException extends RuntimeException {

    private static final String msg = "Input is not a number. Please enter only numeric values (0123456789)";

    public NotANumberException() {
        super(msg);
    }
}
