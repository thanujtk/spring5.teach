package org.tk.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class MainBeanLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        annotationConfigApplicationContext.registerShutdownHook();
    }
}

@Configuration
@ComponentScan(basePackages = {"tk.spring.lifecycle"})
class JavaConfig {

    @Bean(initMethod = "customInit")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle(); // If object is created directly BeanPostProcessor is not called
    }
}