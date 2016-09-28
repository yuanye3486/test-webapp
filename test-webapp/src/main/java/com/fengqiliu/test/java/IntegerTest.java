package com.fengqiliu.test.java;

/**
 * Created by LiuFengqi on 2016/9/22.
 */
public class IntegerTest {

    private enum TEST {
        INT(188);
        int code;

        TEST(int code) {
            this.code = code;
        }
    }

    public static void main(String[] args) {
        testEqual();
    }

    private static void testEqual() {
        Integer integer1 = TEST.INT.code;
        Integer integer2 = TEST.INT.code;
        System.out.println(integer1 == integer2);
    }
}
