package com.fengqiliu.test.hightqualitycode.item9_01.co.company.section1;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		// 多线程对象
		MultiThread multiThread = new MultiThread();
		// 启动多线程
		multiThread.start();

	}
}

class MultiThread extends Thread {
	// @Override
	// public void start(){
	// //调用线程体
	// run();
	// }

	@Override
	public void run() {
		// MultiThread do something.
		for (int i = 0; i < 1000000; i++) {
			System.out.println(Thread.currentThread().getId() + "---我执行了");
		}
	}
}