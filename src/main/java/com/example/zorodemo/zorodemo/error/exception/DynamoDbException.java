package com.example.zorodemo.zorodemo.error.exception;

public class DynamoDbException extends RuntimeException{
    public DynamoDbException () {
    }

    public DynamoDbException (String message) {
        super (message);
    }

    public DynamoDbException (Throwable cause) {
        super (cause);
    }

    public DynamoDbException (String message, Throwable cause) {
        super (message, cause);
    }
}
