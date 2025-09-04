package com.threads;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " started");
            sleep(1000);
            System.out.println(Thread.currentThread().getName() + " finished");
            latch.countDown();
        };

        new Thread(worker, "Worker 1").start();
        new Thread(worker, "Worker 2").start();
        new Thread(worker, "Worker 3").start();

        latch.await();  // Wait for all workers
        System.out.println("All workers finished, proceeding...");
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }
}