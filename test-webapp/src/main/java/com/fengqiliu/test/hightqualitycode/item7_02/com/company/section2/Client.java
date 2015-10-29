package com.fengqiliu.test.hightqualitycode.item7_02.com.company.section2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		
		
	}
}

class Foo<T>{
	//不再初始化，由构造函数初始化
	private T t;
	private T[] tArray;
	private List<T> list= new ArrayList<T>();
	//构造函数初始化
	public Foo(){
		try {
			Class<?> tType = Class.forName("");
			t = (T)tType.newInstance();
			tArray = (T[])Array.newInstance(tType,5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
