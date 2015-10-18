package com.fengqiliu.test.zendofdesignpatterns.observer;

/**
 * Created by LiuFengqi on 2015/10/4.
 */
public class ConcreteSubject extends Subject {
    //具体的业务
    public void doSomething() {
        /*
        * do something
        */
        super.notifyObservers();
    }
}
