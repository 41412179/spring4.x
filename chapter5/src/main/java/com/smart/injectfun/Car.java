package com.smart.injectfun;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Car {

    private String brand;
    private String corp;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
