package com.fengqiliu.test.zendofdesignpatterns.abstractfactory;

/**
 * 抽象产品A
 * Created by LiuFengqi on 2015/9/13.
 */
public abstract class AbstractProductA {
    public void shareMethod() {
        System.out.println("A公共方法...");
    }

    public abstract void doSomething();
}
