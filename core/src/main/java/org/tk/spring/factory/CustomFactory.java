package org.tk.spring.factory;

public class CustomFactory {

    public CustomFactory() {
        System.out.println("Instantiating CustomFactory");
    }

    //BeanB created through factory-bean and factory-method
    public BeanB getBeanBInstance() {
        return new BeanB();
    }
}
