package com.sgalaktionov.homework7.validators;

import com.sgalaktionov.homework7.Exceptions.ValidationFailedException;
import com.sgalaktionov.homework7.Validator;

public class IntegerValidator extends Validator {

    public static void validate(Integer input) {
        //System.out.println("integer validate");
        if ((input>=1) && (input<=10)){
            return;
        }
        throw new ValidationFailedException();
    }
}
