package com.fengqiliu.test.hightqualitycode.item5_08.com.company.section1;

import java.util.ArrayList;
import java.util.List;


public class Client_bak {

    public static void main(String[] args) {
        List<Character> list = new ArrayList<Character>();
        for (char c = 'A'; c < 'H'; c++) {
            list.add(c);
        }
        for (char c : list) {
            System.out.println(c);
        }
        System.out.println("-----");
        //删除B和G之间的元素
        List<Character> list2 = list.subList(1, 3);
        list2.add('W');
//		for(char c:list){			
//			if(c < 'C' || c>'F'){
//				list2.add(c);
//			}			
//		}
//		
        for (char c : list) {
            System.out.println(c);
        }
        System.out.println("-----");
        //打印出list2
        for (char c : list2) {
            System.out.println(c);
        }


    }
}



