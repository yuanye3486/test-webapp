package com.fengqiliu.test.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @athor liufengqi
 * @date 2016/8/1
 * @since 2.0
 */
public class OverloadTest {
    public static void main(String[] args) {
        OverloadTest test = new OverloadTest();
        List<Object> objects =  new ArrayList<Object>(0);
        test.f(objects);
    }

    private void f(Object obj){
        System.out.println("void f(Object obj)");
    }

    private void f(List<? extends Object> objs){
        System.out.println("f(List<Object> objs)");
    }

}
