package com.threads;
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class TestCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(counter::increment);
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        System.out.println("Final Count: " + counter.getCount());
    }
}
