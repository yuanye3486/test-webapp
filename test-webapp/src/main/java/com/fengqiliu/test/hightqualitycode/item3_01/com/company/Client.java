package com.fengqiliu.test.hightqualitycode.item3_01.com.company;

public class Client {
	public static void main(String[] args) {
		//调用接口的实现
		B.s.doSomething();
	}
}
//在接口中存在实现代码
interface B{	
	public static final S s = new S(){
		public void doSomething(){
			System.out.println("我在接口中实现了");
		}
	};
	
}
//被实现的接口
interface S{
	public void doSomething();
}
