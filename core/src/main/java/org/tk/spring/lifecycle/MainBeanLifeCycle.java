package org.tk.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainBeanLifeCycle {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
         annotationConfigApplicationContext.close();
    }
}

