package com.fengqiliu.test.hightqualitycode.item2_10.com.company.section1;

import java.util.Random;

/**
 *
 *正常随机数操作
 * 2011-3-8
 */
public class Client {
	public static void main(String[] args) {
		Random r = new Random();
		for(int i=1;i<4;i++){
			System.out.println("第"+i+"次："+r.nextInt());
		}
	}
}
