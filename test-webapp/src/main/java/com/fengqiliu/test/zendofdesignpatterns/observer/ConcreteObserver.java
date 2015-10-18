package com.fengqiliu.test.zendofdesignpatterns.observer;

/**
 * Created by LiuFengqi on 2015/10/4.
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update() {
        System.out.println("接收到信息， 并进行处理！ ");
    }
}
