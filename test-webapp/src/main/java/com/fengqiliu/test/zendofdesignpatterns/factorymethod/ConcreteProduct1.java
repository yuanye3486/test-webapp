package com.fengqiliu.test.zendofdesignpatterns.factorymethod;

/**
 * Created by LiuFengqi on 2015/9/13.
 */
public class ConcreteProduct1 extends Product {
    @Override
    public void method2() {
        System.out.println(getClass().getName() + "业务逻辑...");
    }
}
