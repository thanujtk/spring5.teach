package org.tk.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainBeanLifeCycle {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        //List all the beans,
        Arrays.stream(annotationConfigApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        annotationConfigApplicationContext.close();
    }
}

