package com.fengqiliu.test.zendofdesignpatterns.abstractfactory;

/**
 * 抽象产品B
 * Created by LiuFengqi on 2015/9/13.
 */
public abstract class AbstractProductB {
    public void shareMethod() {
        System.out.println("B公共方法...");
    }

    public abstract void doSomething();
}
