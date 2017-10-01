package com.sgalaktionov.testhomework4_1;

import com.sgalaktionov.homework4_1.CreditCard;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardTest {
    final static double PRECISION = 1e-12;
    final String CORRECT_NAME = "CorrectName";
    final double correctDoubleBalance = 20.5D;
    final float correctFloatBalance = 20.8F;
    final double correctDoubleAmount = 15.5D;
    final float correctFloatAmount = 20.8F;
    final double toMuchDoubleAmount = 25.5D;
    final float toMuchFloatAmount = 25.5F;
    final double negativeDoubleAmount = -15.D;
    final float negativeFloatAmount = -15.F;
    final double correctDoubleRank = 0.5D;
    final float correctFloatRank = 2.55F;


    @Test
    public void testDecreaseBalanceWithAmountLessThamBalance() throws Exception {
        CreditCard creditCard = new CreditCard(CORRECT_NAME,correctDoubleBalance);
        creditCard.decreaseBalance(correctDoubleAmount);
        assertEquals (correctDoubleBalance-correctDoubleAmount,creditCard.getBalance(),PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountEqualsBalance() throws Exception {
        CreditCard creditCard = new CreditCard(CORRECT_NAME,correctDoubleBalance);
        creditCard.decreaseBalance(creditCard.getBalance());
        assertEquals (0,creditCard.getBalance(),PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountMoreThanBalance() throws Exception {
        CreditCard creditCard = new CreditCard(CORRECT_NAME,correctDoubleBalance);
        creditCard.decreaseBalance(toMuchDoubleAmount);
        //assertEquals (,creditCard.getBalance(),PRECISION);
        assertEquals (correctDoubleBalance-toMuchDoubleAmount,creditCard.getBalance(),PRECISION);
    }
}