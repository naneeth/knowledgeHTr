package com.stackroute.exception;

public class ParagraphNotFoundException extends Exception {
    private String message;

    public ParagraphNotFoundException() {
    }

    public ParagraphNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
