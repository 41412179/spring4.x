package com.smart.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 静态普通方法名匹配切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    /**
     * Perform static checking whether the given method matches. If this
     * returns {@code false} or if the {@link #isRuntime()} method
     * returns {@code false}, no runtime check (i.e. no.
     * {@link #matches(Method, Class, Object[])} call) will be made.
     *
     * @param method      the candidate method
     * @param targetClass the target class (may be {@code null}, in which case
     *                    the candidate class must be taken to be the method's declaring class)
     * @return whether or not this method matches statically
     */
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
