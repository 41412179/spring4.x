package com.smart.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class TransactionManager implements ThrowsAdvice {

    /**
     *定义增强逻辑  方法入参规定：前三个入参要么全部提供，要么全部不提供;最后一个入参是Throwable或其子类
     * @param method
     * @param args
     * @param target
     * @param e
     * @throws Throwable
     */
    public void afterThrowing(Method method, Object[] args, Object target, Throwable e) throws Throwable{
        System.out.println("-----------");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常:" + e.getMessage());
        System.out.println("成功回滚事务。");
    }
}
