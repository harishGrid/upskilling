package com.user;
import org.springframework.web.bind.annotation.*;

import com.user.entity.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/users")
public class UserController {
	private final Map<Long, User> repo = new ConcurrentHashMap<>();
	public UserController() {
		repo.put(1L, new User(1L, "Alice"));
		repo.put(2L, new User(2L, "Bob"));
	}


	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		User u = repo.get(id);
		//if (u == null) throw new ResourceNotFoundException("User not found: " + id);
		return u;
	}


	@GetMapping
	public Collection<User> all() { return repo.values(); }
}