package com.sgalaktionov.homework4_1;

import com.sgalaktionov.homework3_1.*;
import com.sgalaktionov.homework4_1.Exceptions.*;
public class DebitCard extends Card implements ICard{
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
    protected void checkAmontForCorrectValue(double amount) throws IllegalArgumentException {
        super.checkAmontForCorrectValue(amount);
        if (amount>this.getBalance()) {
            throw new IllegalArgumentValue("amount for balance decreace is more than balance");
        }

    }

    @Override
    public void decreaseBalance(double amount) throws IllegalArgumentValue{


        super.decreaseBalance(amount);
        Math.sqrt(-5);
    }



}
