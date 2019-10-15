package org.tk.spring.wiring.auto.sametype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Arrays;

public class MainSameTypeResolve {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        beanA.getBeanB();

    }
}
