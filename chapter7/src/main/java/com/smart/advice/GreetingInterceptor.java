package com.smart.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {

    /**
     * Implement this method to perform extra treatments before and
     * after the invocation. Polite implementations would certainly
     * like to invoke {@link Joinpoint#proceed()}.
     *
     * @param invocation the method invocation joinpoint
     * @return the result of the call to {@link Joinpoint#proceed()};
     * might be intercepted by the interceptor
     * @throws Throwable if the interceptors or the target object
     *                   throws an exception
     */
    // 截获目标类方法的执行，并在前后添加横切逻辑
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments(); // 目标方法入参
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");//在目标方法执行前调用

        Object obj = invocation.proceed();//通过反射机制，调用目标方法

        System.out.println("Please enjoy yourself!");//在目标方法执行后调用
        return obj;
    }
}
