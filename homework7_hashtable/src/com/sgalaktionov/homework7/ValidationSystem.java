package com.sgalaktionov.homework7;

import com.sgalaktionov.homework7.validators.DefaultValidator;
import com.sgalaktionov.homework7.validators.IntegerValidator;
import com.sgalaktionov.homework7.validators.StringValidator;

import java.util.HashMap;

public class ValidationSystem {

    static HashMap<Class, IValidator> validators = new HashMap<Class, IValidator>();

    static {
        validators.put(Integer.class, new IntegerValidator());
        validators.put(String.class, new StringValidator());
        //register your additional validators here
    }

    public ValidationSystem() {
    }

    public static <T> void validate(T input) {

        Class inputClass = input.getClass();

        IValidator validator;
        if (validators.containsKey(inputClass)) {
            validator = validators.get(inputClass);
        }else{
            validator =new DefaultValidator();
        }

        validator.validate(input);
    }



}
