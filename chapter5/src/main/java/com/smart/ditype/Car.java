package com.smart.ditype;

import org.apache.commons.lang3.builder.ToStringBuilder;

// JavaBean关于属性命名的特殊规范:
// 1. xxx属性对应setXxx()方法;
// 2. 变量的前两个字母要么全部大写,要么全部小写;
public class Car {

    private int maxSpeed;
    private String brand;
    private double price;
    private String crop;
    private Boss boss;

    public Car() {}

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public Car(String brand, String crop, double price) {
        this.brand = brand;
        this.crop = crop;
        this.price = price;
    }

    public Car(String brand, String crop, int maxSpeed) {
        this.brand = brand;
        this.crop = crop;
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, Boss boss) {
        this.brand = brand;
        this.boss = boss;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getCrop() {
        return crop;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
