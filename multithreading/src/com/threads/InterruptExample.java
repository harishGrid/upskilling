package com.threads;
public class InterruptExample {
    public static void main(String[] args) throws InterruptedException {
        Thread sleeper = new Thread(() -> {
            try {
                System.out.println("Thread going to sleep...");
                Thread.sleep(5000);
                System.out.println("Thread woke up naturally");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        });

        sleeper.start();

        Thread.sleep(1000);
        System.out.println("Main thread interrupting sleeper");
        sleeper.interrupt();
    }
}