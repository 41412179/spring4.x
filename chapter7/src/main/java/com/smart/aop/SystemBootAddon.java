package com.smart.aop;

import org.springframework.core.Ordered;

public interface SystemBootAddon extends Ordered{
    void onReady();//在系统就绪后调用的方法
}
