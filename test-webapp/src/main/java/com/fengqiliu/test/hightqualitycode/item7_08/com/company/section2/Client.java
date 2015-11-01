package com.fengqiliu.test.hightqualitycode.item7_08.com.company.section2;

import java.util.Arrays;
import java.util.List;

public class Client<T> {


    public static Object[] toArray(List list) {
        //此处的强制类型没必要存在，只是为了保持与源代码对比
        Object[] t = (Object[]) new Object[list.size()];
        for (int i = 0, n = list.size(); i < n; i++) {
            t[i] = list.get(i);
        }
        return t;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B");
        for (String str : (String[]) toArray(list)) {
            System.out.println(str);
        }
    }

}
