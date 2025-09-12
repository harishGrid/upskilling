package com.batch.destroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class PrototypeUserService {

    private final ConfigurableApplicationContext context;

    public PrototypeUserService(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void usePrototypeBean() {
    	PrototypeBeanManualDestroy bean = context.getBean(PrototypeBeanManualDestroy.class);
        try {
            System.out.println("Using prototype bean...");
        } finally {
            if (bean instanceof DisposableBean disposable) {
                try {
                    disposable.destroy();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
