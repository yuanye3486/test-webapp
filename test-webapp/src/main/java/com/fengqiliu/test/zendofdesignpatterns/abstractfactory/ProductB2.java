package com.fengqiliu.test.zendofdesignpatterns.abstractfactory;

/**
 * Created by LiuFengqi on 2015/9/13.
 */
public class ProductB2 extends AbstractProductB {
    @Override
    public void doSomething() {
        System.out.println(getClass().getName() + " doSomething...");
    }
}
