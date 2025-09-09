package com.thread;
import java.util.concurrent.CountDownLatch;

public class SimultaneousStart {
    public static void main(String[] args) throws InterruptedException {
        int workers = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(workers);

        for (int i = 1; i <= workers; i++) {
            new Thread(new Worker(startSignal, doneSignal), "Worker-" + i).start();
        }

        System.out.println("Main thread preparing workers...");
        Thread.sleep(2000); // preparation time
        System.out.println("Main thread gives start signal!");
        startSignal.countDown();  // Let workers proceed

        doneSignal.await();  // Wait for all workers to finish
        System.out.println("All workers finished.");
    }

    static class Worker implements Runnable {
        private CountDownLatch startSignal;
        private CountDownLatch doneSignal;

        public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();  // Wait for start signal
                System.out.println(Thread.currentThread().getName() + " started working.");
                Thread.sleep((long) (Math.random() * 3000)); // simulate work
                System.out.println(Thread.currentThread().getName() + " finished working.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneSignal.countDown();  // Signal done
            }
        }
    }
}