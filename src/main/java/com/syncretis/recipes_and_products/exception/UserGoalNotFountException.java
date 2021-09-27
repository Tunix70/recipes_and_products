package com.syncretis.recipes_and_products.exception;

import org.springframework.http.HttpStatus;

public class UserGoalNotFountException extends RuntimeException {
    public UserGoalNotFountException(HttpStatus status) {
        super("Goal " + status.getReasonPhrase());
    }
}