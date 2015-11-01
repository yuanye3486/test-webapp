package com.fengqiliu.test.zendofdesignpatterns.factorymethod;

/**
 * 抽象产品
 * Created by LiuFengqi on 2015/9/13.
 */
public abstract class Product {
    public void method1() {
        System.out.println("公共业务逻辑...");
    }

    public abstract void method2();
}
