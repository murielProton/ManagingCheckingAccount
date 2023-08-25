package com.example.exception;

public class MyRecordIdMismatchException extends RuntimeException{
    public MyRecordIdMismatchException(){
        super();
    }
    public MyRecordIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
