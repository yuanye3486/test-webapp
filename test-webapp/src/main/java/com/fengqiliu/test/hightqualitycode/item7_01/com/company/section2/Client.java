package com.fengqiliu.test.hightqualitycode.item7_01.com.company.section2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<String>();
        List<Integer> li = new ArrayList<Integer>();
        System.out.println(li.getClass() == li.getClass());
    }
}
