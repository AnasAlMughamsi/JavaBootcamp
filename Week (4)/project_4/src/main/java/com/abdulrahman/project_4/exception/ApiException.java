package com.abdulrahman.project_4.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
