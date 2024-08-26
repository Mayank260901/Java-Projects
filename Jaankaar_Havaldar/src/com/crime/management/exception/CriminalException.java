package com.crime.management.exception;

public class CriminalException extends Exception {
    public CriminalException(String message) {
        super(message);
    }

    public CriminalException(String message, Throwable cause) {
        super(message, cause);
    }
}
