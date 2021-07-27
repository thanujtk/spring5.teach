package org.tk.spring.ehcache;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class EhCacheMain {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EhCacheMain.class.getPackage().getName());
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        MyEhCacheableService service = applicationContext.getBean(MyEhCacheableService.class);
        service.getSquare(15l); // will cache it, you would see MyCacheableService.square console output

        Thread.sleep(1000); //sleep for 10 sec

        service.getSquare(15l);//Request same and no printing on console as it is fetched from cache
    }

}
