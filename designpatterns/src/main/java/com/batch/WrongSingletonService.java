package com.batch;
import org.springframework.stereotype.Service;

@Service
public class WrongSingletonService {

    private final PrototypeBean prototypeBean;

    public WrongSingletonService(PrototypeBean prototypeBean) {
        this.prototypeBean = prototypeBean;
    }

    public String process() {
        return "Using Prototype ID: " + prototypeBean.getId();
    }
}
