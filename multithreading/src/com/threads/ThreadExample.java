package com.threads;

public class ThreadExample extends Thread{
	
	public void run() {
		for(int i=1;i<10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		Thread t=new ThreadExample();
		t.start();
	}

}
