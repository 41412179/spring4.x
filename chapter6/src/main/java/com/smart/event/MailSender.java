package com.smart.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware {
    private ApplicationContext ctx;

    //ApplicationContextAware的接口方法，以便容器启动时注入容器实例
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public void sendEmail(String to) {
        System.out.println("MailSender模拟发送邮件...");
        MailSendEvent mse = new MailSendEvent(ctx, to);
        //向容器中的所有时间监听器发送事件
        ctx.publishEvent(mse);
    }
}
