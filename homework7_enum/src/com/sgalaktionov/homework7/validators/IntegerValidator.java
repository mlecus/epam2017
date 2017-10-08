package com.sgalaktionov.homework7.validators;

import com.sgalaktionov.homework7.Exceptions.ValidationFailedException;
import com.sgalaktionov.homework7.IValidator;

public class IntegerValidator implements IValidator {

    public IntegerValidator() {
    }

    @Override
    public <T> void validate(T input) {

        if (((Integer) input >= 1) && ((Integer) input <= 10)) {
            return;
        }
        throw new ValidationFailedException();
    }
}
