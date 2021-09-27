package com.syncretis.recipes_and_products.exception;

import org.springframework.http.HttpStatus;

public class InvalidDesiredWeight extends RuntimeException {
    public InvalidDesiredWeight(HttpStatus status) {
        super(status.getReasonPhrase());
    }
}