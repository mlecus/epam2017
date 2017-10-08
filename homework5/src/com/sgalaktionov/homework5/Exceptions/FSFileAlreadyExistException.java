package com.sgalaktionov.homework5.Exceptions;

public class FSFileAlreadyExistException extends RuntimeException {
    public FSFileAlreadyExistException(String message) {
        super(message);
    }
}
