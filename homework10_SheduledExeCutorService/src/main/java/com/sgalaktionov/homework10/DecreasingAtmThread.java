package com.sgalaktionov.homework10;

import com.sgalaktionov.homework3_1.ICard;
import com.sgalaktionov.homework4_1.Atm;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static com.sgalaktionov.homework10.Main.FINAL_FULL_BALANCE;

public class DecreasingAtmThread implements Runnable {

    private  ICard card;
    private ArrayList <ScheduledFuture>  decreasingAtmHandlerList;
    private ArrayList <ScheduledFuture>  increasingAtmHandlerList;
    private ScheduledExecutorService executorService;
    private int id;

    public DecreasingAtmThread(ICard card,
                               ArrayList<ScheduledFuture> decreasingAtmHandlerList,
                               ArrayList<ScheduledFuture> increasingAtmHandlerList,
                               ScheduledExecutorService executorService,
                               int id) {
        this.card = card;
        this.decreasingAtmHandlerList = decreasingAtmHandlerList;
        this.increasingAtmHandlerList = increasingAtmHandlerList;
        this.executorService = executorService;
        this.id = id;
    }

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
                TaskCanceller.cancelAllTask(decreasingAtmHandlerList, "cancel decreasing #");
                TaskCanceller.cancelAllTask(increasingAtmHandlerList, "cancel increasing #");
                executorService.shutdown();
            }
        }
    }

}
