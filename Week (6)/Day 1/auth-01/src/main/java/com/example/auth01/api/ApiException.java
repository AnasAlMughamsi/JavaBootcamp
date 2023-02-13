package com.example.auth01.api;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
