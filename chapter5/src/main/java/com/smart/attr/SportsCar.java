package com.smart.attr;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SportsCar {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
