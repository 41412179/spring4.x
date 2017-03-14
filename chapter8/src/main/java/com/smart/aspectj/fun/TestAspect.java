package com.smart.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

@Aspect
public class TestAspect implements Ordered {
    /**
     * @annotation 表示标注了某个注解的所有方法
     */
    @AfterReturning("this(com.smart.Seller)")
    public void thisTest() {
        System.out.println("thisTest() executed!");
    }

    public int getOrder() {
        return 2;
    }
}
