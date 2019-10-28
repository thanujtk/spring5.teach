package org.tk.spring.mix_singleton_prototype.option2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//When using method inject make class as abstract
public abstract class Singleton {

    private Prototype prototype;

    //create proxy for this method using method injection
    public abstract Prototype createPrototype();

    //Though bean is prototype, each call for this will return same object
    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }
}
