package com.sgalaktionov.homework3_1;

import com.sgalaktionov.homework4_1.Exceptions.*;

/**
 * Created by mlecus on 28.09.2017.
 */
public interface ICard {
    public String getName();

    public double getBalance();

    public void increaseBalance(double amount) throws IllegalArgumentException;

    public void decreaseBalance(double amount) throws IllegalArgumentException, IllegalArgumentValue;

    public double convertBalance(double conversionRank) throws IllegalArgumentException;

    public String toSring();
}
