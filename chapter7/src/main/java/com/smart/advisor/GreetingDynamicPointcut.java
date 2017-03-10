package com.smart.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态切点
 * 创建代理时对目标类的每个连接点使用静态切点检查，如果静态切点检查是匹配的，运行时才进行动态切点检查。
 * 在动态切点类中定义静态切点检查方法可避免不必要的动态切点检查，从而大大提高运行效率
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<String>();
    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    //对类进行静态切点检查
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                System.out.println("调用getClassFilter()对" + clazz.getName() + "做静态检查.");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

    //对方法进行静态切点检查
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches(method,clazz)对" + targetClass.getName() + "."
                + method.getName() + "做静态检查.");
        return "greetTo".equals(method.getName());
    }

    /**
     * Check whether there a runtime (dynamic) match for this method,
     * which must have matched statically.
     * <p>This method is invoked only if the 2-arg matches method returns
     * {@code true} for the given method and target class, and if the
     * {@link #isRuntime()} method returns {@code true}. Invoked
     * immediately before potential running of the advice, after any
     * advice earlier in the advice chain has run.
     *
     * @param method      the candidate method
     * @param targetClass the target class (may be {@code null}, in which case
     *                    the candidate class must be taken to be the method's declaring class)
     * @param args        arguments to the method
     * @return whether there's a runtime match
     * @see MethodMatcher#matches(Method, Class)
     */
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("调用matches(method,clazz,args)对" + targetClass.getName() +
        "." + method.getName() + "做动态检查.");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
}
