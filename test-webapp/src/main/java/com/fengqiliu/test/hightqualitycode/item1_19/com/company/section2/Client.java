package com.fengqiliu.test.hightqualitycode.item1_19.com.company.section2;

import java.util.List;

public class Client {

    public static void main(String[] args) {

    }

    public void doSomething(List list, Object element) {
        assert list.remove(element) : "删除元素 " + element + " 失败";
        /*业务处理*/
    }

}
