package com.sgalaktionov.homework7;

import com.sgalaktionov.homework7.validators.DefaultValidator;
import com.sgalaktionov.homework7.validators.IntegerValidator;
import com.sgalaktionov.homework7.validators.StringValidator;

public enum Validators {
    INTEGER_VALIDATOR(Integer.class, new IntegerValidator()),
    STRING_VALIDATOR(String.class, new StringValidator());

    private Class inputClass;
    private IValidator validator;

    Validators(Class inputClass, IValidator validator) {

        this.inputClass = inputClass;
        this.validator = validator;
    }

    public static IValidator getValidator(Class request) {

        for (Validators validator : Validators.values()) {
            if (validator.inputClass.equals(request)) {
                return validator.validator;
            }
        }
        return new DefaultValidator();
    }
}
