package com.sgalaktionov.homework7.validators;

import com.sgalaktionov.homework7.IValidator;

public class DefaultValidator implements IValidator {

    @Override
    public <T> void validate(T input) {
        throw new IllegalArgumentException();
    }
}
