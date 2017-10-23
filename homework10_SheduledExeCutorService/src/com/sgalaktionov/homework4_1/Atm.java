package com.sgalaktionov.homework4_1;

import com.sgalaktionov.homework3_1.ICard;
import com.sgalaktionov.homework4_1.Exceptions.IllegalArgumentValue;

public class Atm {
    public ICard increaseBalance(ICard card, double amount) throws IllegalArgumentException {
        card.increaseBalance(amount);
        return card;
    }

    public ICard decreaseBalance(ICard card, double amount) throws IllegalArgumentException, IllegalArgumentValue {
        card.decreaseBalance(amount);
        return card;
    }
}
