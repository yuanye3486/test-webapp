package com.fengqiliu.test.hightqualitycode.item3_09.com.company.section2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //定义一个继承ArrayList的内部类
        class Sub extends ArrayList {
        }
        //声明和赋值
        List l2 = new Sub();
    }


}

