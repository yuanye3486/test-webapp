package com.fengqiliu.test.hightqualitycode.item7_04.com.company.section2;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        read(Arrays.asList("A"));

    }

    public static <E> void read(List<? extends E> list) {
        for (E e : list) {
            System.out.println(e.getClass());
            //业务逻辑处理
        }
    }


}
