package com.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.command.dto.UserCreatedEvent;
import com.command.entity.UserAccount;
import com.command.repo.UserAccountRepository;

@Service
public class UserCommandService {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;
	
	public String createUser(UserAccount user) {
		UserCreatedEvent event=new UserCreatedEvent(user.getId(),user.getName(),user.getEmail());
		kafkaTemplate.send("user-event",event);
		userAccountRepository.save(user);
		return "User Event Sended to kafka Succesfully";
	}

}
