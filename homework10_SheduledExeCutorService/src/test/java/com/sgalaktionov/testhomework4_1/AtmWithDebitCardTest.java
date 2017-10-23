package com.sgalaktionov.testhomework4_1;

import com.sgalaktionov.homework3_1.ICard;
import com.sgalaktionov.homework4_1.Atm;
import com.sgalaktionov.homework4_1.DebitCard;
import com.sgalaktionov.homework4_1.Exceptions.IllegalArgumentValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtmWithDebitCardTest {
    final static double PRECISION = 1e-12;

    ICard card;
    Atm atm = new Atm();

    @Before
    public void testSetUp() {
        card = new DebitCard("Ivanov", 100D);
    }

    @Test
    public void testIncreaseBalance() throws Exception {
        atm.increaseBalance(card, 50D);
        assertEquals(100D + 50D, card.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountLessThanBalance() throws Exception {
        atm.decreaseBalance(card, 50D);
        assertEquals(50D, card.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountEqualBalance() throws Exception {
        atm.decreaseBalance(card, 100D);
        assertEquals(0, card.getBalance(), PRECISION);
    }

    @Test(expected = IllegalArgumentValue.class)
    public void testDecreaseBalanceWithAmountMoreThanBalance() throws Exception {
        atm.decreaseBalance(card, 150D);
    }
}