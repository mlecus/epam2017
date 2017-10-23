package com.sgalaktionov.homework4_1;

import com.sgalaktionov.homework3_1.*;


public class CreditCard extends Card {
    public CreditCard(String name, double balance) {
        super(name, balance);
    }

    public CreditCard(String name) {
        super(name);
    }

    public CreditCard(Card card) {
        super(card);
    }

}
