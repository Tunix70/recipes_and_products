package com.syncretis.recipes_and_products.exception;

public class UnsupportedUnitException extends RuntimeException {
    public UnsupportedUnitException(String unit) {
        super("Unsupported unit (" + unit + "). Unit should be in g.");
    }
}