package com.fengqiliu.test.hightqualitycode.item2_10.com.company.section3;

import java.util.Random;

/**
 *
 * @author Phenix
 * 2011-3-8
 */
public class Client {
	public static void main(String[] args) {
		Random r = new MyRandom();
		for(int i=1;i<4;i++){
			System.out.println("第"+i+"次："+r.nextInt());
		}
	}
}
