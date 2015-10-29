package com.fengqiliu.test.hightqualitycode.item11_02.com.company.section9;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.TreeBidiMap;

public class Client {
	public static void main(String[] args) {
		// key、value都不允许重复的Map
		BidiMap bidiMap = new TreeBidiMap();
		bidiMap.put(1, "壹");
		// 根据key获取value
		System.out.println(bidiMap.get(1));
		// 根据value获取key
		System.out.println(bidiMap.getKey("壹"));
		// 根据value删除键值对
		bidiMap.removeValue("壹");
		System.out.println(bidiMap.size());
	}
}
