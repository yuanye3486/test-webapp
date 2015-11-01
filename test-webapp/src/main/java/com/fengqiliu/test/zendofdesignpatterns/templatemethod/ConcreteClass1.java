package com.fengqiliu.test.zendofdesignpatterns.templatemethod;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doAnything() {
        System.out.println(getClass().getName() + " do anything");
    }

    @Override
    protected void doSomething() {
        System.out.println(getClass().getName() + " do something");
    }
}
