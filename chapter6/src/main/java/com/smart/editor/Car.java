package com.smart.editor;

public class Car {
    private int maxSpeed;
    private double price;
    private String brand;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String toString() {
        return "brand:" + brand + "/maxSpeed:" + maxSpeed + "/price:" + price;
    }

}
