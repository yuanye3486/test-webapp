package com.fengqiliu.test.zendofdesignpatterns.command;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class ConcreteReceiver2 extends Receiver {

    //每个接收者都必须处理一定的业务逻辑
    public void doSomething() {
        System.out.println("ConcreteReceiver2.doSomething() ...");
    }
}