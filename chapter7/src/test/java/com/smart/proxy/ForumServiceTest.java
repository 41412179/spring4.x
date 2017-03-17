package com.smart.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {

    @Test
    public void proxy() {
        // 业务类正常编码测试
//        ForumService forumService = new ForumServiceImpl();
//        forumService.removeTopic(10);
//        forumService.removeForum(1012);

//         使用JDK动态代理
        //希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();
        //经目标业务类和横切代码编织在一起
        PerformanceHandler handler = new PerformanceHandler(target);
        //根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        //调用代理实例
        proxy.removeTopic(10);
        proxy.removeForum(1012);

        //使用CGLib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        //通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeTopic(10);
        forumService.removeForum(1012);

    }
}
