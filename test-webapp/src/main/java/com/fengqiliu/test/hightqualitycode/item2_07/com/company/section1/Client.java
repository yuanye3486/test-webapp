package com.fengqiliu.test.hightqualitycode.item2_07.com.company.section1;


public class Client {
    public static void main(String[] args) {
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        compare(i, j);

        System.out.println();
    }

    //比较两个装箱对象大小
    public static void compare(Integer i, Integer j) {
        System.out.println(i == j);
        System.out.println(i > j);
        System.out.println(i < j);
    }
}
