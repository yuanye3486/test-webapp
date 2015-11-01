package com.fengqiliu.test.zendofdesignpatterns.prototype;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class Client {

    public static void main(String[] args) {
        PrototypeClass prototype = new PrototypeClass();
        PrototypeClass p = prototype.clone();
        System.out.println(prototype.equals(p));

    }
}
