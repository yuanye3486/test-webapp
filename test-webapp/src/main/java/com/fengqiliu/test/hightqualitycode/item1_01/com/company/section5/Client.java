package com.fengqiliu.test.hightqualitycode.item1_01.com.company.section5;

/**
 * 注意变量位置
 */
public class Client {
    //定义一个人的年龄

    public static int age;

    //静态代码块
    static {
        age = 100;
    }

    public static void main(String[] args) {
        System.out.println("Your age is：" + age);
    }
}
