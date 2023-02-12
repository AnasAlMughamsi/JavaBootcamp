package com.example.store.api;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
