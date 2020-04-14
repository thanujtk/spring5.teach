package org.tk.spring.factorybean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Calendar;

public class MainFactoryBean {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        //List all the beans,
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Calendar calendarFactory = (Calendar) context.getBean("getCalendarFactory"); //Not CalendarFactory, as CalendarFactory is a FactoryBean

        System.out.println(calendarFactory.getTime());
        System.out.println(context.getBean("getCalendar", Calendar.class).getTime()); //same as above

        //SpEL
        System.out.println(context.getBean("getRandSeed"));
        context.close();
    }
}
