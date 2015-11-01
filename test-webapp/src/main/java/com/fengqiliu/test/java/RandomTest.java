package com.fengqiliu.test.java;

import java.util.Random;


public class RandomTest {

    public static void main(String[] args) {
        testNextDouble();

    }

    private static void testNextDouble() {
        Random random = new Random();
        System.out.println(random.nextInt(100000));
    }

}
