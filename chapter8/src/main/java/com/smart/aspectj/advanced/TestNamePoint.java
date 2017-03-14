package com.smart.aspectj.advanced;

import org.aspectj.lang.annotation.Pointcut;

public class TestNamePoint {

    /*
     * @Pointcut 命名切点注解
     * "within(com.smart.*)" 切点表达式
     * private 切点引用修饰符
     * inPackage 切点名称
     */
    @Pointcut("within(com.smart.*)")
    private void inPackage(){}

    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){}

    @Pointcut("inPackage() and greetTo()")
    public void inPkgGreetTo() {}

}
