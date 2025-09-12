package com.batch.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch.PrototypeBean;
import com.batch.SingletonBean;
import com.batch.SingletonService;
import com.batch.WrongSingletonService;
import com.batch.concurency.CounterService;
import com.batch.destroy.PrototypeUserService;

@RestController
public class TestController {

	@Autowired
    private WrongSingletonService wrongService;
	@Autowired
    private SingletonService correctService;
	
	@Autowired
	private SingletonBean singletonBean;
	@Autowired
    private PrototypeBean prototypeBean;

	@Autowired
    private PrototypeUserService service;
	
	@Autowired
    private CounterService counterService;
	
    @GetMapping("/wrong")
    public String testWrong() {
        return wrongService.process();
    }

    @GetMapping("/correct")
    public String testCorrect() {
        return correctService.process();
    }
    
    @GetMapping("/scopes")
    public String getBeanIds() {
        return String.format("""
                Singleton: %s
                Prototype: %s
                """,
                singletonBean.getId(),
                prototypeBean.getId()
        );
    }
    
    @GetMapping("/destroy")
    public String protoTypeDestroy() {
    	service.usePrototypeBean();
    	return "Prototype Bean Succesfully Deleted";
    }
    
    @GetMapping("/counter")
    public String counterService() {
    	return counterService.runThreads();
    }
    
}
