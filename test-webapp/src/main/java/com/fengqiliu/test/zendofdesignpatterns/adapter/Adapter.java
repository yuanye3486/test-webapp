package com.fengqiliu.test.zendofdesignpatterns.adapter;

/**
 * Created by LiuFengqi on 2015/10/4.
 */
public class Adapter extends Adaptee implements Target {
    public void request() {
        super.doSomething();
    }
}