package com.smart.fb;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    // 2.实例化Car Bean
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] info = carInfo.split(",");
        car.setBrand(info[0]);
        car.setMaxSpeed(Integer.parseInt(info[1]));
        car.setPrice(Double.parseDouble(info[2]));
        return car;
    }

    // 3.返回Car的类型
    public Class<?> getObjectType() {
        return Car.class;
    }

    // 4.标识通过该FactoryBean返回的Bean是singleton
    public boolean isSingleton() {
        return false;
    }

    // 1.接收逗号分隔的属性设置信息
    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getCarInfo() {
        return carInfo;
    }
}
