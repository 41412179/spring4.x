package com.smart.proxy;

import java.security.PublicKey;

public class MethodPerformance {

    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
       reset(serviceMethod);
    }

    public void printPerformance() {
        //记录目标类方法执行完成后的系统时间
        end = System.currentTimeMillis();
        long elapse = end - begin;
        //报告目标类方法的执行时间
        System.out.println(this.serviceMethod + "花费" + elapse + "毫秒。");
    }

    public void reset(String method) {
        this.serviceMethod = method;
        //记录目标类方法开始执行点的系统时间
        this.begin = System.currentTimeMillis();
    }
}
