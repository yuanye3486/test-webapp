package com.fengqiliu.test.zendofdesignpatterns.command;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public abstract class Receiver {
    //抽象接收者， 定义每个接收者都必须完成的业务
    public abstract void doSomething();
}
