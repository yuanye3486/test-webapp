package com.fengqiliu.test.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/1/18.
 */
public class ListTest {

    public static void main(String[] args){
        ListTest listTest = new ListTest();
//        listTest.testRemove();
        listTest.testRemove2();
    }

    private void testRemove2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        while (list.size()>0){
            System.out.println(list.remove(0));
        }
    }

    private void testRemove(){
        List<String> list = new ArrayList<>();

        System.out.println("---------------- remove in for -----------------");
        list.clear();
        list.add("1");
        list.add("2");
        list.add("3");
        for (int i = 0; i < list.size(); i++){
            list.remove(i);
            System.out.println(i);
        }
        System.out.println("list size after remove = " + list.size());

        System.out.println("---------------- remove in forEach -----------------");
        list.clear();
        list.add("1");
        list.add("2");
        list.add("3");
        for (String str : list){
            list.remove(str);
        }
        System.out.println("list size after remove = " + list.size());

        System.out.println("---------------- remove in Iterator -----------------");
        list.clear();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println("list size after remove = " + list.size());

    }
}
