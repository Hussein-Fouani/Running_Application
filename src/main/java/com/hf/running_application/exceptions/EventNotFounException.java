package com.hf.running_application.exceptions;

public class EventNotFounException  extends RuntimeException {
    private final String message;
    private final Long Id;

    public EventNotFounException(String message, Long id) {
        this.message = message;
        Id = id;
    }

    public EventNotFounException(String message, String message1, Long id) {
        super(message);
        this.message = message1;
        Id = id;
    }}