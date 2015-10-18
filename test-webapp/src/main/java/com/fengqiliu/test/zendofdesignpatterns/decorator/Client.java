package com.fengqiliu.test.zendofdesignpatterns.decorator;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}