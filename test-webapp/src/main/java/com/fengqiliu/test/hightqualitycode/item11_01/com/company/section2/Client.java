package com.fengqiliu.test.hightqualitycode.item11_01.com.company.section2;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Client {
    public static void main(String[] args) {
        //多值Map
        Multimap<String, String> phoneBook = ArrayListMultimap.create();
        phoneBook.put("张三", "110");
        phoneBook.put("张三", "119");
        System.out.println(phoneBook.get("张三"));
    }
}
