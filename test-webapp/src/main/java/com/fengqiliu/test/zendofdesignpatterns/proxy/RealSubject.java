package com.fengqiliu.test.zendofdesignpatterns.proxy;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class RealSubject implements Subject {
    //实现方法
    @Override
    public void request() {
        System.out.println("RealSubject 业务逻辑...");
    }
}
