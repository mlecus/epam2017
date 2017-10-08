package com.sgalaktionov.homework7;

import com.sgalaktionov.homework7.validators.DefaultValidator;
import com.sgalaktionov.homework7.validators.IntegerValidator;
import com.sgalaktionov.homework7.validators.StringValidator;


public class ValidationSystem {
    public ValidationSystem() {

    }

    public static <T> void validate(T input) {
        Class inputClass = input.getClass();
        if (inputClass.equals(Integer.class)) {
            IntegerValidator.validate((Integer) input);
        }else if (inputClass.equals(String.class)) {
            StringValidator.validate((String) input);
        }else{
            DefaultValidator.validate(input);
        }
    }
}
