package com.executorframework;
import java.util.concurrent.*;
import java.time.LocalTime;

public class ScheduledExecutorExample2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Current time: " + LocalTime.now());

        scheduler.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);

        Thread.sleep(15000); 
        scheduler.shutdown();
    }
}