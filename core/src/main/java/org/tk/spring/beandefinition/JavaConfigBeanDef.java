package org.tk.spring.beandefinition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.tk.spring.beandefinition"})
public class JavaConfigBeanDef {

//    @Bean
//    public AnotherMyBean getAnotherMyBean() {
//        return new AnotherMyBean();
//    }
}
