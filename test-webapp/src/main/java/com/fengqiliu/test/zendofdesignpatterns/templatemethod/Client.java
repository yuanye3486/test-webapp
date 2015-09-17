package com.fengqiliu.test.zendofdesignpatterns.templatemethod;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public class Client {
    public static void main(String[] args){
        AbstractClass tpl1 = new ConcreteClass1();
        tpl1.templateMethod();

        AbstractClass tpl2 = new ConcreteClass2();
        tpl2.templateMethod();


    }
}
