package com.fengqiliu.test.hightqualitycode.item9_12.com.company.section1;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        //定义初始长度为5
        List<String> list = new ArrayList<String>(5);
        //加入10个元素
        for (int i = 0; i < 10; i++) {
            list.add("");
        }
    }
}
