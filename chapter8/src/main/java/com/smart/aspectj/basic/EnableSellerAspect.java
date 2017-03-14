package com.smart.aspectj.basic;

import com.smart.Seller;
import com.smart.SmartSeller;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EnableSellerAspect {
    @DeclareParents(value = "com.smart.NaiveWaiter",// 1.为NaiveWaiter添加接口实现
            defaultImpl = SmartSeller.class) // 2.默认的接口实现类
    public Seller seller; // 3.要实现的目标接口
}
