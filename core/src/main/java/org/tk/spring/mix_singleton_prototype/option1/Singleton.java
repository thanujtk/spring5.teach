package org.tk.spring.mix_singleton_prototype.option1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singleton implements ApplicationContextAware {

    private Prototype prototype;
    private ApplicationContext applicationContext;


    //Each call get new instance as bean is defined as prototype in xml configuration
    public Prototype createPrototype() {
       return applicationContext.getBean("prototype", Prototype.class);
    }

    //Though bean is prototype, each call for this will return same object
    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
