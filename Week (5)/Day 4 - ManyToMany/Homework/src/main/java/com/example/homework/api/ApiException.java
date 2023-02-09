package com.example.homework.api;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
