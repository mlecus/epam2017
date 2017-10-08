package com.sgalaktionov.homework7.validators;

import com.sgalaktionov.homework7.Validator;

public class DefaultValidator extends Validator {

    //@Override
    public static <T> void validate(T input) {
        throw new IllegalArgumentException();
    }
}
