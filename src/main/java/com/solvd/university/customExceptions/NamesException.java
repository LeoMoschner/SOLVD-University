package com.solvd.university.customExceptions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NamesException extends RuntimeException {
    private final static Logger LOGGER = LogManager.getLogger(NamesException.class);

    public NamesException(String message) {
        LOGGER.error(message);
    }
}
