package com.hf.running_application.exceptions;

public class ClubNotFoundException extends RuntimeException {
    private final String message;
    private final Long Id;

    public ClubNotFoundException(String message, Long id) {
        this.message = message;
        Id = id;
    }

    public ClubNotFoundException(String message, String message1, Long id) {
        super(message);
        this.message = message1;
        Id = id;
    }
}
