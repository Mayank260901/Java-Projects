package com.crime.management.exception;

public class PoliceOfficerException extends Exception {
    public PoliceOfficerException(String message) {
        super(message);
    }

    public PoliceOfficerException(String message, Throwable cause) {
        super(message, cause);
    }
}
