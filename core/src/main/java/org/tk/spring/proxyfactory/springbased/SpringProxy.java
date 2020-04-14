package org.tk.spring.proxyfactory.springbased;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;

public class SpringProxy {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
       // factory.addAdvice(new MyAdvice());
        factory.setExposeProxy(true);

        Pojo proxy = (Pojo) factory.getProxy();
        int result = proxy.add(3,4);
        System.out.println("Result from proxy : "+ result);
    }
}

class SimplePojo implements  Pojo {

    public int add(int a, int b) {
        return a + b;
    }
}

interface  Pojo {
    int add(int a, int b);
}

class MyAdvice implements Advice, Advisor, MethodInterceptor {

    @Override
    public Advice getAdvice() {
        return this;
    }

    @Override
    public boolean isPerInstance() {
        return true;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }
}