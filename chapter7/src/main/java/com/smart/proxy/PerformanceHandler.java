package com.smart.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler { // 实现InvocationHandler接口

    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;   // target为目标业务类
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass() + "." + method.getName());
        Object object = method.invoke(target, args);    //通过反射方法调用业务类的目标方法
        PerformanceMonitor.end();
        return object;
    }
}
