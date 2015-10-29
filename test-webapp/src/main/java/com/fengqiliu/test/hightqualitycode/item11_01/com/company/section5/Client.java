package com.fengqiliu.test.hightqualitycode.item11_01.com.company.section5;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public class Client {
	public static void main(String[] args) {
		// 姓名、年龄对
		Map<String, Integer> user = new HashMap<String, Integer>();
		user.put("张三", 20);
		user.put("李四", 22);
		user.put("王五", 25);
		// 所有年龄大于20岁的人员
		Map<String, Integer> filtedMap = Maps.filterValues(user,
				new Predicate<Integer>() {
					public boolean apply(Integer value) {
						return value > 20;
					}
				});
		System.out.println(filtedMap);
	}
}
