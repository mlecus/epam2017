package com.sgalaktionov.homework8_1.exceptions;

public class LimitedListCapacityExceed extends RuntimeException {
    public LimitedListCapacityExceed(String message) {
        super(message);
    }

    public LimitedListCapacityExceed() {
    }
}
