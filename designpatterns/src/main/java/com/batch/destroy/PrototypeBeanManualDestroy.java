package com.batch.destroy;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBeanManualDestroy {

    private final String resource;

    public PrototypeBeanManualDestroy() {
        this.resource = "Expensive Resource Created";
        System.out.println(resource);
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Cleaning up prototype bean!");
    }
}



