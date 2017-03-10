package com.smart.proxy;

public class PerformanceMonitor {

    // 1.通过一个ThreadLocal保存与调用线程相关的性能监视信息
    private static ThreadLocal<MethodPerformance> performanceRecords = new ThreadLocal<MethodPerformance>();

    // 2.启动对某一方法的性能监视
    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = performanceRecords.get();
        if (mp == null) {
            mp = new MethodPerformance(method);
            performanceRecords.set(mp);
        }
        else mp.reset(method);
    }

    public static void end() {
        System.out.println("end monitor...");
        MethodPerformance mp = performanceRecords.get();

        // 3.打印方法性能监视的结果信息
        mp.printPerformance();
    }
}
