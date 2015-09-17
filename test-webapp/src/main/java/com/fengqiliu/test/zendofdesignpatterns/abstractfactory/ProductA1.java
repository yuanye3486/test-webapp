package com.fengqiliu.test.zendofdesignpatterns.abstractfactory;

/**
 * Created by LiuFengqi on 2015/9/13.
 */
public class ProductA1 extends AbstractProductA {
    @Override
    public void doSomething() {
        System.out.println(getClass().getName() + " doSomething...");
    }
}
