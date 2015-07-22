package com.fengqiliu.test.java;

public class StringTest {

	public static void main(String[] args) {
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
