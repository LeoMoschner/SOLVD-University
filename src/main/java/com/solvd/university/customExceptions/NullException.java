package com.solvd.university.customExceptions;

public class NullException extends RuntimeException {

    private static final String msg = "Null input. Please enter a correct value";

    public NullException() {
        super(msg);
    }
}
