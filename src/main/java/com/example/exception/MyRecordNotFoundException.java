package com.example.exception;

public class MyRecordNotFoundException extends RuntimeException {
    public MyRecordNotFoundException() {
        super();
    }
    public MyRecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
