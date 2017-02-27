package com.smart.groovy;

public class LogDao {

    private String dataProvider;

    public void saveLog() {}

    public void init() {
        System.out.println("initMethod...");
    }

    public void destroy() {
        System.out.println("destroyMethod...");
    }

    public String getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(String dataProvider) {
        this.dataProvider = dataProvider;
    }
}
