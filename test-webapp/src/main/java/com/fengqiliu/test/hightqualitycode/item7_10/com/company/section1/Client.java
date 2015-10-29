package com.fengqiliu.test.hightqualitycode.item7_10.com.company.section1;

import java.lang.reflect.Method;

public class Client {
	public static void main(String[] args) throws Exception {
		//方法名称
		String methodName = "doStuff";
		Method m1 = Foo.class.getDeclaredMethod(methodName);
		Method m2 = Foo.class.getMethod(methodName);
		

	}
	
	static class Foo {
		void doStuff() {}
	}
}

