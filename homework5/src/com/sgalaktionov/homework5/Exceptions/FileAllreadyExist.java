package com.sgalaktionov.homework5.Exceptions;

public class FileAllreadyExist extends RuntimeException{
    public FileAllreadyExist(String message) {
        super(message);
    }
}
