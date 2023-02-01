package com.example.homework.exception;

public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
