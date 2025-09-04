package com.threads;
import java.util.concurrent.CountDownLatch;

public class SimpleCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // We want 3 workers to finish before main continues
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println("Worker 1: working...");
            try { Thread.sleep(1000); } catch (Exception e) {}
            System.out.println("Worker 1: done!");
            latch.countDown(); // reduce count
        }).start();

        new Thread(() -> {
            System.out.println("Worker 2: working...");
            try { Thread.sleep(2000); } catch (Exception e) {}
            System.out.println("Worker 2: done!");
            latch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Worker 3: working...");
            try { Thread.sleep(1500); } catch (Exception e) {}
            System.out.println("Worker 3: done!");
            latch.countDown();
        }).start();

        System.out.println("Main thread: waiting for workers...");
        latch.await();  // waits until countDown called 3 times
        System.out.println("Main thread: All workers finished, continuing...");
    }
}
