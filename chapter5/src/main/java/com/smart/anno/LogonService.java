package com.smart.anno;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LogonService implements BeanNameAware{

    //@Autowired默认按类型（byType）匹配的方式在容器中查找Bean，当且仅当只有一个匹配的Bean时，Spring会将其注入@Autowired标注的变量中
    @Lazy//对Bean实施延迟依赖注入，要注意@Lazy注解必须同时标注在属性及目标Bean上，二者缺一，则延迟注入无效
    @Autowired(required = false)//required=false,即使找不到匹配的Bean也不会抛出异常
    private LogDao logDao;

    @Autowired
    private UserDao userDao;

    public void saveLog() {
        logDao.saveLog();
    }

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    /*
    @Autowired//对类方法进行标注，自动将UserDao传给入参
    @Qualifier("userDao")//使用@Qualifier指定注入Bean的名称
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void init(@Qualifier("userDao") UserDao userDao, LogDao logDao) {//Spring允许对入参标注@Qualifier指定Bean的名称
        this.userDao = userDao;
        this.logDao = logDao;
    }
    */


    public void setBeanName(String name) {
        System.out.println("beanName:" + name);
    }
}
