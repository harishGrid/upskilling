package com.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.query.dto.UserCreatedEvent;
import com.query.entity.UserQuery;
import com.query.repo.UserQueryRepository;

@Service
public class UserQueryService {
	
	@Autowired
	private UserQueryRepository userQueryRepository;
	
	@KafkaListener(topics = "user-events",groupId = "user-query-group")
	public void handleUserCreatedEvent(UserCreatedEvent event) {
		UserQuery query=new UserQuery();
		
		query.setId(event.getUserId());
		query.setEmail(event.getEmail());
		query.setName(event.getName());
		
	    userQueryRepository.save(query);
	}

}
