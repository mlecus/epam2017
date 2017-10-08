package com.sgalaktionov.homework7;

public class ValidationSystem {


    public ValidationSystem() {
    }

    public static <T> void validate(T input) {

        //IValidator validator = Validators.getValidator(input.getClass());
        //validator.validate(input);
        Validators.getValidator(input.getClass()).validate(input);
    }
}
