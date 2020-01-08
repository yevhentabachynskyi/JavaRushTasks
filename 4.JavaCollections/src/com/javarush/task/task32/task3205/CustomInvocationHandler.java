package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by XPMUser on 4/15/19.
 */
public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods withMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods withMethods) {
        this.withMethods = withMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println(method.getName() + " in");
        result = method.invoke(withMethods, args);
        System.out.println(method.getName() + " out");
     return result;
    }
}
