package com.batch;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingletonService {
	
	@Autowired
	private ObjectFactory<PrototypeBean> factory;
	
	public String process() {
		PrototypeBean bean = factory.getObject();
		return "Using Prototype ID: " + bean.getId();
	}

}
