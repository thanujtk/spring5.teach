package org.tk.spring.wiring.both.xml_annotation;

import org.springframework.beans.factory.annotation.Value;


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
