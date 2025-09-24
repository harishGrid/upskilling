package com.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceDistributedTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceDistributedTracingApplication.class, args);
	}

}
