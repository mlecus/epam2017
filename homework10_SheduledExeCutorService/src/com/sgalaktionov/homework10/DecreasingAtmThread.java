package com.sgalaktionov.homework10;

import com.sgalaktionov.homework3_1.ICard;
import com.sgalaktionov.homework4_1.Atm;

import static com.sgalaktionov.homework10.Main.FINAL_FULL_BALANCE;

public class DecreasingAtmThread implements Runnable {
    private  ICard card;
    public DecreasingAtmThread(ICard card){
        this.card = card;
    }
    private int id;

    @Override
    public void run() {
        Atm atm = new Atm();
        double balance = 0;

        double amount = 5 * Math.random();
        synchronized (card) {
            balance = card.getBalance();
            System.out.println("#" + id + ": " + (amount) + "\t" + balance);
            if (balance + amount < FINAL_FULL_BALANCE) {
                atm.increaseBalance(card, amount);
            } else {
                System.out.println("#" + id + ": card is full " + balance);
                cancelAllTask(decreasingAtmHandlerList, "cancel decreasing #");
                cancelAllTask(increasingAtmHandlerList, "cancel increasing #");
                executorService.shutdown();
            }
        }
    }

}
