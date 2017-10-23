package com.sgalaktionov.homework10;

import com.sgalaktionov.homework4_1.Atm;
import com.sgalaktionov.homework4_1.DebitCard;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {

    public static int FINAL_FULL_BALANCE = 1000;
    public static int FINAL_EMPTY_BALANCE = 0;

    public static int MINIMAL_DECREASING_ATM_AMOUNT = 3;
    public static int MAXIMAL_DECREASING_ATM_AMOUNT = 5;

    public static int MINIMAL_INCREASING_ATM_AMOUNT = 3;
    public static int MAXIMAL_INCREASING_ATM_AMOUNT = 10;


    private static void cancelAllTask(ArrayList<ScheduledFuture> taskHandlerList, String description) {
        for (ScheduledFuture taskHandler : taskHandlerList) {
            System.out.println(description + taskHandlerList.indexOf(taskHandler));
            taskHandler.cancel(true);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        DebitCard debitCard = new DebitCard("Smith", 500);

        ArrayList<ScheduledFuture> decreasingAtmHandlerList = new ArrayList<>();
        ArrayList<ScheduledFuture> increasingAtmHandlerList = new ArrayList<>();

        for (int i = 0; i < MINIMAL_DECREASING_ATM_AMOUNT
                + Math.random() * (MAXIMAL_DECREASING_ATM_AMOUNT - MINIMAL_DECREASING_ATM_AMOUNT); i++) {
            System.out.println("create decreasing atm #" + i);
            int finalI = i + 1;
            Runnable decreasingAtm = new DecreasingAtmThread(debitCard);
            ScheduledFuture<?> decreasingAtmHandler = executorService.scheduleAtFixedRate(decreasingAtm, 200, (3 + (int) Math.random() * 2) * 40, TimeUnit.MILLISECONDS);
            decreasingAtmHandlerList.add(decreasingAtmHandler);
        }

        for (int i = 0; i < MINIMAL_INCREASING_ATM_AMOUNT
                + Math.random() * (MAXIMAL_INCREASING_ATM_AMOUNT - MINIMAL_INCREASING_ATM_AMOUNT); i++) {
            System.out.println("create increasing atm #" + i);
            int finalI = i;
            Runnable increasingAtm = new DecreasingAtmThread();
            ScheduledFuture<?> increasingAtmHandler = executorService.scheduleAtFixedRate(increasingAtm, 200, (3 + (int) Math.random() * 2) * 40, TimeUnit.MILLISECONDS);
            increasingAtmHandlerList.add(increasingAtmHandler);
        }

        while (true) {
            boolean allDead = true;
            for (ScheduledFuture future : increasingAtmHandlerList) {
                if (!future.isDone()) allDead = false;
            }
            for (ScheduledFuture future : decreasingAtmHandlerList) {
                if (!future.isDone()) allDead = false;
            }
            if (allDead) {
                System.out.println(debitCard.getBalance());
                System.out.println("main dead");
                break;
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
