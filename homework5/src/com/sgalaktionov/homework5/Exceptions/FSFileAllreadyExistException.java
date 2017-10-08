package com.sgalaktionov.homework5.Exceptions;

public class FSFileAllreadyExistException extends RuntimeException {
    public FSFileAllreadyExistException(String message) {
        super(message);
    }
}
