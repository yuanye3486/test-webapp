package com.fengqiliu.test.hightqualitycode.item3_09.com.company.section1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List l1 = new ArrayList();
        List l2 = new ArrayList() {
        };
        List l3 = new ArrayList() {{
        }};
        System.out.println(l1.getClass() == l2.getClass());
        System.out.println(l2.getClass() == l3.getClass());
        System.out.println(l1.getClass() == l3.getClass());
    }
}

