package org.tk.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.tk.spring.lifecycle"})
public class JavaConfig {

    @Bean(initMethod = "customInit")
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle(); // If object is created directly BeanPostProcessor is not called, so called when compenent scan load the bean
    }
}