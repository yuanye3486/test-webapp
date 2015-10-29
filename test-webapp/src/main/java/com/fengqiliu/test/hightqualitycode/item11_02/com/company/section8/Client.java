package com.fengqiliu.test.hightqualitycode.item11_02.com.company.section8;

import java.util.Arrays;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

public class Client {
	public static void main(String[] args) {
		//一个盒子中装了4个球
		Bag box =new HashBag(Arrays.asList("red","blue","black","blue"));
		//又增加了3个蓝色球
		box.add("blue", 3);
		//球的数量为7
		System.out.println(box.size());
		//蓝色球数量为5
		System.out.println(box.getCount("blue"));
	}
}
