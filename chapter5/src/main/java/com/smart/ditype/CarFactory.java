package com.smart.ditype;

public class CarFactory {

    // 非静态工厂方法，必须实例化工厂类后才能调用工厂方法
    public Car createHongqiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }

    // 静态工厂方法
    public static Car createHongQiCar() {
        Car car = new Car();
        car.setBrand("红旗CA72");
        return car;
    }
}
