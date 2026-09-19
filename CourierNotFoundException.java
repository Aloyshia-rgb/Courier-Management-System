package com.aec.exception;

public class CourierNotFoundException
        extends Exception {

    public CourierNotFoundException(String message) {
        super(message);
    }
}