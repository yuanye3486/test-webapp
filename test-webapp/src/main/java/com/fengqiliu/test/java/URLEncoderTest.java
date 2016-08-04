package com.fengqiliu.test.java;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		encode("今日头条_content_szp20160204.js", "utf-8");

	}
	
	public static void encode(String s, String enc) throws UnsupportedEncodingException{
		String encode = URLEncoder.encode(s, enc);
        String decode = URLDecoder.decode("%E4%BB%8A%E6%97%A5%E5%A4%B4%E6%9D%A1_content_szp20160204.js","utf-8");
		System.out.println("原文：" + s);
		System.out.println("编码：" + encode);
        System.out.println("解码：" + decode);
	}

}
