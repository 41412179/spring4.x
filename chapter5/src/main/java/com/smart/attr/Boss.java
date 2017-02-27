package com.smart.attr;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

public class Boss {
    //声明初始化对象，配合设置级联属性
    private Car car = new Car();
    private List favorites = new ArrayList();
    private Map jobs = new HashMap();
    private Properties mails = new Properties();

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public void setFavorites(List favorites) {
        this.favorites = favorites;
    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public List getFavorites() {
        return favorites;
    }

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }
}
