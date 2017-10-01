package com.sgalaktionov.testhomework4_1;

import com.sgalaktionov.homework4_1.DebitCard;
import com.sgalaktionov.homework4_1.Exceptions.IllegalArgumentValue;
import org.junit.Assert;
import org.junit.Test;


public class DebitCardTest {
    final static double PRECISION = 1e-12;
    final String CORRECT_NAME = "Ivanov";
    final double correctDoubleBalance = 20.5D;
    final float correctFloatBalance = 20.8F;
    final double correctDoubleAmount = 15.5D;
    final double toMuchDoubleAmount = 25.5D;
    final double negativeDoubleAmount = -15.D;
    final float negativeFloatAmount = -15.F;


    @Test
    public void testDecreaseBalanceWithCorrectAmount() throws Exception {
        DebitCard debitCard = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        debitCard.decreaseBalance(correctDoubleAmount);
        Assert.assertEquals(correctDoubleBalance - correctDoubleAmount, debitCard.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountEqualsBalance() throws Exception {
        DebitCard debitCard = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        debitCard.decreaseBalance(debitCard.getBalance());
        Assert.assertEquals(0, debitCard.getBalance(), PRECISION);
    }

    @Test(expected = IllegalArgumentValue.class)
    public void testDecreaseBalanceWithToMuchAmount() throws Exception {
        DebitCard debitCard = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        debitCard.decreaseBalance(toMuchDoubleAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithDoubleNegativeInfinity() throws Exception {
        DebitCard card = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        card.decreaseBalance(Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithDoublePositiveInfinity() throws Exception {
        DebitCard card = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        card.decreaseBalance(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithDoubleNaN() throws Exception {
        DebitCard card = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        card.decreaseBalance(Double.NaN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithNegativeFloatParameterValue() throws Exception {
        DebitCard card = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        card.decreaseBalance(negativeFloatAmount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDecreaseBalanceWithNegativeDoubleParameterValue() throws Exception {
        DebitCard card = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        card.decreaseBalance(negativeDoubleAmount);
    }

    @Test
    public void testDecreaseBalanceWithZeroParameterValue() throws Exception {
        DebitCard card = new DebitCard(CORRECT_NAME, correctDoubleBalance);
        card.decreaseBalance(0);
        Assert.assertEquals(correctDoubleBalance, card.getBalance(), PRECISION);

        card = new DebitCard(CORRECT_NAME, correctFloatBalance);
        card.decreaseBalance(0);
        Assert.assertEquals(correctFloatBalance, card.getBalance(), PRECISION);
    }
}