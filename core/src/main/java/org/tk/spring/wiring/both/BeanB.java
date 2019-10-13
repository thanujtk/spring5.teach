package org.tk.spring.wiring.both;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class BeanB {

    private BeanA beanA;

    @Value("#{beanA}")
    public void setBeanA( BeanA beanA) {//Using bean Id in SpringEL
        this.beanA = beanA;
    }

    public BeanA getBeanA() {
        return this.beanA;
    }
}
