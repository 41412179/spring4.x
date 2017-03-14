package com.smart.aspectj.advanced;

import com.smart.Monitorable;
import com.smart.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 增强织入顺序：
 * 1.如果增强在同一个切面类中声明，则依照增强在切面类中定义的顺序进行织入
 * 2.如果增强位于不用的切面类中，且这些切面类都实现了org.springframework.core.Ordered接口，
 * 则由接口方法的顺序号决定（顺序号小的先织入）
 * 3.如果增强位于不同的切面类中，且这些切面类没有实现org.springframework.core.Ordered接口，
 * 则织入顺序是不确定的
 */
@Aspect
public class TestAspect {

//    @After("within(com.smart.*) && execution(* greetTo(..))") //与运算
//    public void greetToFun() {
//        System.out.println("---greetToFun() executed!---");
//    }
//
//    @Before("!target(com.smart.NaiveWaiter) && execution(* serveTo(..))") //非与运算
//    public void notServeInNaiveWaiter() {
//        System.out.println("---notServeInNaiveWaiter() executed!---");
//    }
//
//    @AfterReturning("target(com.smart.Waiter) || target(com.smart.Seller)") //或运算
//    public void waiterOrSeller() {
//        System.out.println("---waiterOrSeller() executed!---");
//    }
//
//    @Before("TestNamePoint.inPkgGreetTo()")
//    public void pkgGreetTo() {
//        System.out.println("--pkgGreetTo() executed!--");
//    }
//
//    @Before("!target(com.smart.NaiveWaiter) && TestNamePoint.inPkgGreetTo()")
//    public void pkgGreetToNotNaiveWaiter() {
//        System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
//    }

    /**
     * 访问连接点信息：
     * AspectJ 使用org.aspectj.lang.JoinPoint接口表示目标类连接点对象。
     * 如果是环绕增强，则使用org.aspectj.lang.ProceedingJoinPoint表示连接点对象
     * @param pjp ProceedingJoinPoint 连接点对象
     * @throws Throwable
     */
    @Around("execution(* greetTo(..)) && target(com.smart.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("--------joinPointAccess-------");

        System.out.println("args[0]: " + pjp.getArgs()[0]);
        System.out.println("signature: " + pjp.getSignature());
        pjp.proceed();
        System.out.println("--------joinPointAccess-------");
    }

    /**
     * 绑定连接点方法入参：
     * args()、this()、target()、@args()、@within()、@target()、和@annotation()
     * 这7个函数除了可以指定类名，还可以指定参数名，将目标对象连接点上的方法入参绑定到增强的方法中。
     * 切点匹配和参数绑定的过程：
     * 首先，args()根据参数名称在增强方法中查找名称相同的入参并获知对应的类型，
     * 这样就知道了匹配连接点方法的入参的类型；其次连接点方法入参类型所在的位置
     * 则由参数名在args()函数中声明的位置决定。
     * @param num
     * @param name
     */
    @Before("target(com.smart.NaiveWaiter) && args(name, num,..)")
    public void bindJoinPointParams(int num, String name) {
        System.out.println("-------bindJoinPointParams----------");
        System.out.println("name: " + name);
        System.out.println("num: " + num);
        System.out.println("-------bindJoinPointParams----------");
    }

    /**
     * 绑定代理对象：
     * 使用this()或target()函数可绑定被代理对象实例
     * 类名通过增强方法中的同名入参的类型间接决定
     * @param waiter
     */
    @Before("this(waiter)")
    public void bindProxyObject(Waiter waiter) {
        System.out.println("----------bindProxyObject()------------");
        System.out.println(waiter.getClass().getName());
        System.out.println("----------bindProxyObject()------------");
    }

    /**
     * 绑定类注解对象:
     * .@within() 和 @target()函数可以将目标类的注解对象绑定到增强方法中
     */
    @Before("@within(m))")
    public void bindTypeAnnoObject(Monitorable m) {
        System.out.println("---------bindTypeAnnoObject()-------");
        //在使用CGLib代理时，其类的注解对象也被代理
        System.out.println(m.getClass().getName());
        System.out.println("---------bindTypeAnnoObject()-------");
    }

    /**
     * 绑定返回值：
     * 在后置增强中，可以通过returning绑定连接点方法的返回值
     */
    @AfterReturning(value = "target(com.smart.SmartSeller)", returning = "retVal")
    public void bindReturnValue(int retVal) {
        System.out.println("---------bindReturnValue()-----------");
        System.out.println("returnValue: " + retVal);
        System.out.println("---------bindReturnValue()-----------");
    }

    /**
     * 绑定异常：
     * 使用AfterThrowing注解的throwing成员绑定连接点抛出的异常
     * @param iae
     */
    @AfterThrowing(value = "target(com.smart.SmartSeller)", throwing = "iae")
    public void bindException(IllegalArgumentException iae) {
        System.out.println("---------bindException()-----------");
        System.out.println("exception: " + iae.getMessage());
        System.out.println("---------bindException()-----------");
    }
}
