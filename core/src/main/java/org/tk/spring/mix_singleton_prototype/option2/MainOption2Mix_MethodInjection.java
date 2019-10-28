package org.tk.spring.mix_singleton_prototype.option2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainOption2Mix_MethodInjection {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext8.xml");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        Singleton singleton = applicationContext.getBean("singleton", Singleton.class);

        Prototype prototype1 =  singleton.createPrototype();
        Prototype prototype2 =  singleton.createPrototype();

    }
}
