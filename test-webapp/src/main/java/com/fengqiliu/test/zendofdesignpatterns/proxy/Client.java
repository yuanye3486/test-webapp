package com.fengqiliu.test.zendofdesignpatterns.proxy;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class Client {

    public static void main(String[] args) {
        Subject proxy = new Proxy(new RealSubject());
        proxy.request();
    }

}
