package com.threads;
public class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

    Runnable r=()-> {
    		for(int i=0;i<10;i++) {
    			try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    			counter.increment();
    		}
		};
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(counter.getCount());
    }
}