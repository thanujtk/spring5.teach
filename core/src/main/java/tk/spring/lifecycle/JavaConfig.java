package tk.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public BeanLifecycle beanLifecycle() {
        return new BeanLifecycle();
    }
}