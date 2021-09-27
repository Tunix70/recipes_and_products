package com.syncretis.recipes_and_products.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(HttpStatus status) {
        super("User " + status.getReasonPhrase());
    }
}