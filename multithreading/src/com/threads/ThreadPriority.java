package com.threads;

public class ThreadPriority {
	public static void main(String[] args) {
	
		Thread highPriority = new Thread(()->{
			for(int i=1;i<=5;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("High Priority thread");
			}
		});
		
		Thread lowPriority=new Thread(()->{
			for(int i=1;i<=5;i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Low Priority thread");
			}
		});
		
		highPriority.setPriority(Thread.MAX_PRIORITY);
		lowPriority.setPriority(Thread.MIN_PRIORITY);
		
		highPriority.start();
		lowPriority.start();
		
	}
}
