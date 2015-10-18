package com.fengqiliu.test.zendofdesignpatterns.adapter;

/**
 * Created by LiuFengqi on 2015/10/4.
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("ConcreteTarget.request() ...");
    }
}
