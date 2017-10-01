package com.sgalaktionov.testhomework4_1;

import com.sgalaktionov.homework4_1.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    final static double PRECISION = 1e-12;
    final String CORRECT_NAME = "Ivanov";
    final double correctDoubleBalance = 20.5D;
    final double correctDoubleAmount = 15.5D;
    final double toMuchDoubleAmount = 25.5D;

    @Test
    public void testDecreaseBalanceWithAmountLessThanBalance() throws Exception {
        CreditCard creditCard = new CreditCard(CORRECT_NAME, correctDoubleBalance);
        creditCard.decreaseBalance(correctDoubleAmount);
        assertEquals(correctDoubleBalance - correctDoubleAmount, creditCard.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountEqualsBalance() throws Exception {
        CreditCard creditCard = new CreditCard(CORRECT_NAME, correctDoubleBalance);
        creditCard.decreaseBalance(creditCard.getBalance());
        assertEquals(0, creditCard.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountMoreThanBalance() throws Exception {
        CreditCard creditCard = new CreditCard(CORRECT_NAME, correctDoubleBalance);
        creditCard.decreaseBalance(toMuchDoubleAmount);
        assertEquals(correctDoubleBalance - toMuchDoubleAmount, creditCard.getBalance(), PRECISION);
    }
}