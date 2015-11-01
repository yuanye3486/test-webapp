package com.fengqiliu.test.hightqualitycode.item1_05.com.company.section2;

/**
 * 带有变长参数的方法重载，在调用时失败。
 */

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        String[] strs = null;
        client.methodA("China", strs);
    }

    public void methodA(String str, Integer... is) {
        System.out.println("Integer");
    }

    public void methodA(String str, String... strs) {
        System.out.println("String");
    }
}
