package com.fengqiliu.test.zendofdesignpatterns.proxy;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class Proxy implements Subject {
    //要代理哪个实现类
    private Subject subject = null;

    //默认被代理者
    public Proxy() {
        this.subject = new Proxy();
    }

    //通过构造函数传递代理者
    public Proxy(Object... objects) {
        subject = (Subject)objects[0];
    }

    //实现接口中定义的方法
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    //预处理
    private void before() {
    System.out.println("Proxy.before() ...");
    }

    //善后处理
    private void after() {
        System.out.println("Proxy.after() ...");
    }
}