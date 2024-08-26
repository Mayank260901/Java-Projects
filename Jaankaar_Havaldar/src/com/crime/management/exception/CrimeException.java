package com.crime.management.exception;

public class CrimeException extends Exception {
    public CrimeException(String message) {
        super(message);
    }

    public CrimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
