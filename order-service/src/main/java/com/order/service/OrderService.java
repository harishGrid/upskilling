package com.order.service;

import org.springframework.stereotype.Service;

import com.order.feign.UserFeign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class OrderService {
	private final UserFeign userClient;
	public OrderService(UserFeign userClient) { this.userClient = userClient; }


	@CircuitBreaker(name = "userServiceCB", fallbackMethod = "userFallback")
	@Retry(name = "userServiceRetry")
	public String createOrderForUser(Long userId) {
		var user = userClient.getUserById(userId);
		return "Order created for user: " + user.name();
	}


	public String userFallback(Long userId, Throwable t) {
		return "Order created for guest because user-service failed or user not found";
	}
}