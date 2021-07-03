package org.tk.spring.proxyfactory.javabased;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
         this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("InvocaionHandler.invoke called, MethodName="+method.getName()+", Arguments="+ Arrays.toString(args)+", Proxy="+proxy.getClass());
        long start = System.nanoTime();

        Object result = method.invoke(target, args);

        long end = System.nanoTime() - start;
        System.out.println("Executing "+method.getName()+" finished in "+ end +" ns");
        return  result;
    }
}
