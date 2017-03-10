package com.smart.concept;

public class ForumService {

    private PerformanceMonitor monitor;
    private TransactionManager transManager;
    private TopicDao topicDao;
    private ForumDao forumDao;

    public void removeTopic(int topicId) {
        monitor.start();
        transManager.beginTransaction();

        topicDao.removeTopic(topicId);

        transManager.commit();
        monitor.end();
    }

    public void createForum(Forum forum) {
        monitor.start();
        transManager.beginTransaction();

        forumDao.create(forum);

        transManager.commit();
        monitor.end();
    }
}
