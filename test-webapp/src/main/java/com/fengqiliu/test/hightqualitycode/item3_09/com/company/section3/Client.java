package com.fengqiliu.test.hightqualitycode.item3_09.com.company.section3;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //定义一个继承ArrayList的内部类
        class Sub extends ArrayList {
            {
                //初始化块
            }
        }
        //声明和赋值
        List l3 = new Sub();
    }


}

