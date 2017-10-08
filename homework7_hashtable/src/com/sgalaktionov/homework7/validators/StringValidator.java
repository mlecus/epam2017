package com.sgalaktionov.homework7.validators;

import com.sgalaktionov.homework7.Exceptions.ValidationFailedException;
import com.sgalaktionov.homework7.IValidator;

public class StringValidator implements IValidator {

    @Override
    public <T> void validate(T input) {

        if (((String) input).matches("[A-Z].*")) {
            return;
        }
        throw new ValidationFailedException();
    }
}
