package com.fengqiliu.test.zendofdesignpatterns.abstractfactory;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public class Client {
    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractProductA a1 = creator1.createProductA();
        AbstractProductB b1 = creator1.createProductB();
        a1.shareMethod();
        a1.doSomething();
        b1.shareMethod();
        b1.doSomething();

        AbstractCreator creator2 = new Creator2();
        AbstractProductA a2 = creator2.createProductA();
        AbstractProductB b2 = creator2.createProductB();
        a2.shareMethod();
        a2.doSomething();
        b2.shareMethod();
        b2.doSomething();
    }
}
