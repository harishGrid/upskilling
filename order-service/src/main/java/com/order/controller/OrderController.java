package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order/{id}")
	public String creatingOrderForUser(@PathVariable("id") Long userId) {
		String orderForUser = orderService.createOrderForUser(userId);
		return orderForUser;
	}

}
