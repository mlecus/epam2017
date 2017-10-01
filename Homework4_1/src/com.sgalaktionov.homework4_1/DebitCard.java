package com.sgalaktionov;

import com.sgalaktionov.homework3_1.Card;

public class DebitCard extends Card{
    public DebitCard(String name, double balance) {
        super(name, balance);
    }

    public DebitCard(String name) {
        super(name);
    }

    public DebitCard(Card card) {
        super(card);
    }

    @Override
    public void decreaseBalance(double amount) throws IllegalArgumentException {
        //super.decreaseBalance(amount);
        
        //if (this.getBalance())
    }
}
