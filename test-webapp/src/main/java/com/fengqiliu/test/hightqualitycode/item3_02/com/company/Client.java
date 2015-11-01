package com.fengqiliu.test.hightqualitycode.item3_02.com.company;

public class Client {
    public static int i = 1;

    static {
        i = 100;
    }

    public static void main(String[] args) {
        System.out.println(i);
    }

}
