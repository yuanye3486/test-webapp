package com.fengqiliu.test.zendofdesignpatterns.strategy;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }
}
