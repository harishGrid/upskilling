package com.batch.concurency;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
	
	@Autowired
	private ObjectFactory<CounterBean> factory;
	
	public String runThreads() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(()->{
			CounterBean bean=factory.getObject();
			for (int j = 0; j < 1000; j++) {
				Thread.sleep(1000);
                bean.increment();
            }
			System.out.println(Thread.currentThread().getName()
                    + " final count = " + bean.getCounter());
			return Thread.currentThread().getName()
                    + " final count = " + bean.getCounter();
		});
		executor.shutdown();
		return null;
	}
	
	

}
