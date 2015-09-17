package com.fengqiliu.test.java;

public class StringTest {

	public static void main(String[] args) {
		
//		test1();
//		test2();
		subStringTest();
	}

	private static void subStringTest() {
		String s = "sf/j/slf2322jl23l323j422aklfaakk";
		System.out.println(s.substring(s.lastIndexOf("/j/"), s.length()));
		
	}

	private static void test2() {
		String s = "12345678\n";
		System.out.println(s.substring(0, s.length()-2));
		
	}

	private static void test1() {
		String s = "helloqweoqweq";
		s = s.replace("o", "\n");
		String[] sa = s.split(";");
		for(String ss : sa)
		System.out.println(ss);
		System.out.println(s);

		String pattern = "sfdja*77?jh[jh]";
		String newStr = pattern.replace("*", "\\*").replace("?", "\\?").replace("[", "\\[").replace("]", "\\]");
		System.out.println(newStr);
		
	}
	
	

}
