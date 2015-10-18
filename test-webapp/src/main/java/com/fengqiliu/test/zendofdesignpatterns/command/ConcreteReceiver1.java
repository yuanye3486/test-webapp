package com.fengqiliu.test.zendofdesignpatterns.command;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class ConcreteReceiver1 extends Receiver {

    @Override
    public void doSomething() {
        System.out.println("ConcreteReceiver1.doSomething() ...");
    }
}
