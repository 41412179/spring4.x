package com.smart.tagdepend;

public class SysInit {

    public SysInit() {
        System.out.println("System init...");
        //模拟从数据库加载系统设置信息
        SystemSettings.SESSION_TIME_OUT = 10;
        SystemSettings.REFRESH_CYCLE = 100;
    }
}
