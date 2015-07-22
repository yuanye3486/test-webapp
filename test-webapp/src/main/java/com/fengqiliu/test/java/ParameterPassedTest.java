package com.fengqiliu.test.java;
import java.util.ArrayList;
import java.util.List;


public class ParameterPassedTest {

	public static void main(String[] args) {
		List<String> list = null;
		test(list);
		System.out.println(list.size());// NullPointerException
	}
	
	public static void test(List<String> list){
		if(list == null){
			list = new ArrayList<String>();
		}
		list.add("hello");
	}

}
