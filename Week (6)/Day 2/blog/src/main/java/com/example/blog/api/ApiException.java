package com.example.blog.api;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
