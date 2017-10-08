package com.sgalaktionov.testhomework7;

import com.sgalaktionov.homework7.Exceptions.ValidationFailedException;
import com.sgalaktionov.homework7.ValidationSystem;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationSystemTest {
    @Test
    public void testValidateInt () throws ValidationFailedException {
        ValidationSystem.validate(1);
        ValidationSystem.validate(5);
        ValidationSystem.validate(10);
    }
    @Test (expected = ValidationFailedException.class)
    public void testValidateIntFails() throws ValidationFailedException {
        ValidationSystem.validate(11);
    }
    @Test (expected = ValidationFailedException.class)
    public void testValidateIntFails2 () throws ValidationFailedException {
        ValidationSystem.validate(0);
    }
    @Test
    public void testValidateString () throws ValidationFailedException {
        ValidationSystem.validate("Hello");
        ValidationSystem.validate("Hello world, abc");
    }
    @Test (expected = ValidationFailedException.class)
    public void testValidateStringFails() throws ValidationFailedException {
        ValidationSystem.validate("hello");

    }
    @Test (expected = ValidationFailedException.class)
    public void testValidateStringFails2() throws ValidationFailedException {
        ValidationSystem.validate("");
    }

}