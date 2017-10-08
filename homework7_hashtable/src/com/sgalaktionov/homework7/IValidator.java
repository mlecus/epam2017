package com.sgalaktionov.homework7;

import java.util.HashMap;

public abstract interface IValidator {
    public abstract <T>  void validate(T input);
}
