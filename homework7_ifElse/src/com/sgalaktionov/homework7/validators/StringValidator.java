package com.sgalaktionov.homework7.validators;

import com.sgalaktionov.homework7.Exceptions.ValidationFailedException;
import com.sgalaktionov.homework7.Validator;

import java.util.regex.Pattern;

public class StringValidator extends Validator {

    public  static void validate(String input) {
        if (input.matches("[A-Z].*")){
            return;
        }
        throw new ValidationFailedException();
    }
}
