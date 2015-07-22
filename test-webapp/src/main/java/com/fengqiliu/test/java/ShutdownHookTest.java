package com.fengqiliu.test.java;
import java.util.Date;
import java.util.Scanner;


public class ShutdownHookTest {

	public static void main(String[] args) {
		 Runtime.getRuntime().addShutdownHook(new CleanThread("main thread"));
		 Scanner in=new Scanner(System.in);
		 for(;;){
			 new Thread(new Runnable(){
				 
				@Override
				public void run() {
					Runtime.getRuntime().addShutdownHook(new CleanThread("sub thread"));
					for(;;){
//						System.out.println(new Date());
					}
				}
			 }).start();
			 String line = in.nextLine();
			 if("exit".equals(line)){
				 System.exit(0);
			 }
		 }

	}
	
	public static class CleanThread extends Thread{
		private String msg;
		
		public CleanThread(String msg){
			this.msg = msg;
		}
		
		@Override
		public void run(){
			Date date = new Date();
			System.out.println("XXXXXXXXXXXXXXX==========>" + msg + ": " + date);
		}
	}

}
