package com.smart.aspectj.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 1.通过该注解将PreGreetingAspect标识为一个切面
public class PreGreetingAspect {

    @Before("execution(* greetTo(..))") // 2.定义切点和增强类型
    public void beforeGreeting() { // 3.增强的横切逻辑
        System.out.println("How are you");
    }
}
