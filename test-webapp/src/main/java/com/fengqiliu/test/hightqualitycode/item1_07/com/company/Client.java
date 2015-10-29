package com.fengqiliu.test.hightqualitycode.item1_07.com.company;

/**
 * 警惕自增的陷阱
 *
 */
public class Client {
	public static void main(String[] args) {
		int count =0;
		for(int i=0;i<10;i++){
			count=count++;
		}
		System.out.println("count="+count);
	}
}

class Mock{
	public static void main(String[] args) {
		int count =0;
		for(int i=0;i<10;i++){
			count=mockAdd(count);
		}
		System.out.println("count="+count);
	}

	public static int mockAdd(int count){
		//先保存初始值
		int temp =count;
		//做自增操作
		count = count+1;
		//返回原始值
		return temp;
	}
}
