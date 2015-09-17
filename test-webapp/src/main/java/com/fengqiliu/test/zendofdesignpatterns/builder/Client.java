package com.fengqiliu.test.zendofdesignpatterns.builder;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public class Client {
    public static void main(String[] args){
        Director director = new Director();
        Product product = director.getAProduct();
        product.doSomething();
    }
}
