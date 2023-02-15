package com.example.products.api;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
