package com.threads;
public class DeadlockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                sleep(100);
                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) {
					System.out.println("lock 2 finised");
				}
				}
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                sleep(100);
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) {
					System.out.println("lock 1 finised");
				}
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { }
    }
}