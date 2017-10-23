package com.sgalaktionov.homework10;

import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;

public class TaskCanceller {
    public static  void cancelAllTask(ArrayList<ScheduledFuture> taskHandlerList, String description) {
        for (ScheduledFuture taskHandler : taskHandlerList) {
            System.out.println(description + taskHandlerList.indexOf(taskHandler));
            taskHandler.cancel(true);
        }
    }
}
