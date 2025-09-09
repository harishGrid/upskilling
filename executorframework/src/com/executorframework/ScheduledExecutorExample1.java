package com.executorframework;
import java.util.concurrent.*;

public class ScheduledExecutorExample1 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Task executed after delay");

        scheduler.schedule(task, 5, TimeUnit.SECONDS);

        Thread.sleep(6000);
        scheduler.shutdown();
    }
}