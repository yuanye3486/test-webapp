package com.fengqiliu.test.java;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SyncTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		Runner runner = new Runner("runner");
		threadPool.execute(runner);
		threadPool.execute(runner);
		threadPool.execute(runner);
		threadPool.shutdownNow();
	}
	
	static class Runner implements Runnable{
		private String msg;

		public Runner(String msg){
			this.msg = msg;
		}
		
		@Override
		public synchronized void run(){
			System.out.println(msg + " start...");
			long i=10000000000l;
			while(i>0){
				i--;
			}
			System.out.println(msg + " finish");
		}
		
	}

}
