package com.fengqiliu.test.java;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		encode("category.coll_inc.1hour/drId=52,mt=4,name=国内博客", "utf-8");

	}
	
	public static void encode(String s, String enc) throws UnsupportedEncodingException{
		String encode = URLEncoder.encode(s, enc);
		System.out.println("原文：" + s);
		System.out.println("编码：" + encode);
	}

}
