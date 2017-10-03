package com.sgalaktionov.homework5.Exceptions;

public class FSInvalidSymbolExtension extends RuntimeException{
    String errorString;
    int errorSymbolIndex;
    char errorValue;
    public FSInvalidSymbolExtension(){
        super();
    }
    public FSInvalidSymbolExtension(String message) {
        super(message);
    }


}
