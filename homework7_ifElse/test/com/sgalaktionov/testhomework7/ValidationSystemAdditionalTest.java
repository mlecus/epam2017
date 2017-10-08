package com.sgalaktionov.testhomework7;

import com.sgalaktionov.homework7.Exceptions.ValidationFailedException;
import com.sgalaktionov.homework7.ValidationSystem;
import org.junit.Test;

public class ValidationSystemAdditionalTest {
    @Test(expected = IllegalArgumentException.class)
    public void testValidateInt() throws IllegalArgumentException {
        ValidationSystem.validate(1F);
    }
}
