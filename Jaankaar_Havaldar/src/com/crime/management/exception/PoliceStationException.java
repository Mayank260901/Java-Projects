package com.crime.management.exception;

public class PoliceStationException extends Exception {
    public PoliceStationException(String message) {
        super(message);
    }

    public PoliceStationException(String message, Throwable cause) {
        super(message, cause);
    }
}
