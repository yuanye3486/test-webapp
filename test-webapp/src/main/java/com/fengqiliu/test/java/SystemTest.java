package com.fengqiliu.test.java;

/**
 * Created by Administrator on 2016/1/20.
 */
public class SystemTest {
    public static void main(String[] args) {
        System.out.println( System.getProperty("user.dir"));
        System.out.println( System.getProperty("java.io.tmpdir"));
        System.out.println( System.getProperty("SHUTDOWN_HOOK_KEY"));
    }
}
