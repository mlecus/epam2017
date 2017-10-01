package com.sgalaktionov.testhomework3_1;

import org.junit.Test;
import com.sgalaktionov.homework3_1.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by mlecus on 29.09.2017.
 */
public class CardConstructorsTest {
    final static double PRECISION = 1e-12;
    final String correctName = "CorrectName";
    final double correctDoubleBalance = 0.5D;
    final float correctFloatBalance = 0.8F;
    final double correctNegativeDoubleBalance = -0.5D;

    @Test
    public void testCardByNameConstructorWithCorrectName() {
        Card card = new Card(correctName);
        assertEquals(correctName, card.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameConstructorWithNullName() {
        new Card((String) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameConstructorWithEmptyName() {
        new Card("");
    }

    public void testCardByNameAndBalanceConstructorWithCorrectParametersValue() {
        Card card = new Card(correctName, correctDoubleBalance);
        assertEquals(correctName, card.getName());
        assertEquals(correctDoubleBalance, card.getBalance(), PRECISION);

        card = new Card(correctName, correctFloatBalance);
        assertEquals(correctFloatBalance, card.getBalance(), PRECISION);

        card = new Card(correctName, correctNegativeDoubleBalance);
        assertEquals(correctNegativeDoubleBalance, card.getBalance(), PRECISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameAndBalanceConstructorWithNullName() {
        new Card((String) null, correctDoubleBalance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameAndBalanceConstructorWithEmptyName() {
        new Card("", correctDoubleBalance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameAndBalanceConstructorWithDoubleNegativeInfinity() throws Exception {
        new Card(correctName, Double.NEGATIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameAndBalanceConstructorWithDoublePositiveInfinity() throws Exception {
        new Card(correctName, Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCardByNameAndBalanceConstructorWithDoubleNaN() throws Exception {
        new Card(correctName, Double.NaN);
    }

    @Test
    public void testCardCopyConstructor() throws Exception {
        Card card = new Card(correctName);
        Card cardCopy = new Card(card);
        assertEquals(card.getName(), cardCopy.getName());
        assertEquals(card.getBalance(), cardCopy.getBalance(), PRECISION);

        card = new Card(correctName, correctDoubleBalance);
        cardCopy = new Card(card);
        assertEquals(card.getName(), cardCopy.getName());
        assertEquals(card.getBalance(), cardCopy.getBalance(), PRECISION);
    }

}
