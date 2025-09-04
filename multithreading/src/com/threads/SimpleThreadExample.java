package com.threads;

public class SimpleThreadExample {
	public static void main(String[] args) {
		
		Thread thread = new Thread(()->{
			for(int i=1;i<5;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
		});
		
		thread.start();

		
	}
}
