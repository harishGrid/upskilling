package com.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.User;
import com.order.dto.UserDto;


@FeignClient(name = "user-service")
public interface UserFeign {
	@GetMapping("/users/{id}")
	UserDto getUserById(@PathVariable("id") Long id);
}
