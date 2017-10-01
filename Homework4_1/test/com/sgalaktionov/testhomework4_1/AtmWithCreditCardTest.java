package com.sgalaktionov.testhomework4_1;


import com.sgalaktionov.homework3_1.ICard;
import com.sgalaktionov.homework4_1.Atm;
import com.sgalaktionov.homework4_1.CreditCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AtmWithCreditCardTest {
    final static double PRECISION = 1e-12;

    ICard card;
    Atm atm;

    @Before
    public void testSetUp() {

        card = new CreditCard("Ivanov", 100D);
        atm = new Atm();
    }

    @Test
    public void testIncreaseBalance() throws Exception {
        //card.increaseBalance(50D);
        atm.increaseBalance(card, 50D);
        assertEquals(100D + 50D, card.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountLessThanBalance() throws Exception {
        //card.decreaseBalance(50D);
        atm.decreaseBalance(card, 50D);
        assertEquals(50D, card.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountEqualBalance() throws Exception {
        //card.decreaseBalance(100D);
        atm.decreaseBalance(card, 100D);
        assertEquals(0, card.getBalance(), PRECISION);
    }

    @Test
    public void testDecreaseBalanceWithAmountMoreThanBalance() throws Exception {
        //card.decreaseBalance(150D);
        atm.decreaseBalance(card, 150D);
        assertEquals(-50D, card.getBalance(), PRECISION);
    }
}