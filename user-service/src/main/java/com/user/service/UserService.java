package com.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repo.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public String saveUser(User user) {
		User save = userRepository.save(user);
		
		if(save.getId()!=null) {
			return "User Saved Succesfully";
		}
		return "User Not Saved";
	}
	
	public User getUserById(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(()-> new NullPointerException("User not exist with ID"));
	}
	
	public String deleteUser(Long userId) {
		
		try {
		 userRepository.deleteById(userId);
		 return "User deleted Succesfully";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "User Not deleted";
	}
	
	public String updateUser(Long userId,User user) {
		Optional<User> existUser = userRepository.findById(userId);
		
		if(existUser.isPresent()) {
			User user2 = existUser.get();
			user2.setName(user.getName());
			return "User Updated Succesfully";
		}
		return "User Not Updated";
	}
	

}
