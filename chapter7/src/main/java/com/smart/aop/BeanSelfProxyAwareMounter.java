package com.smart.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BeanSelfProxyAwareMounter implements SystemBootAddon, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ApplicationContext applicationContext;

    @Autowired//注入Spring容器
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void onReady() {//实现系统启动器接口中的装备就绪方法
        //从容器中获取所有注入的的自动代理Bean
        Map<String, BeanSelfProxyAware> proxyAwareMap =
                applicationContext.getBeansOfType(BeanSelfProxyAware.class);
        if (proxyAwareMap != null) {
            for (BeanSelfProxyAware beanSelfProxyAware : proxyAwareMap.values()) {
                beanSelfProxyAware.setSelfProxy(beanSelfProxyAware);
                if (logger.isDebugEnabled()) {
                    logger.debug("{}注册自身被代理的实例。");
                }
            }
        }
    }


    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
