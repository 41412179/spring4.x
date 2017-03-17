package com.smart.proxy;

public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
//        PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
//        PerformanceMonitor.begin("com.smart.proxy.ForumServiceImpl.removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        test();
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        PerformanceMonitor.end();
    }

    private void test() {System.out.println("----------------测试------------------");}
}
