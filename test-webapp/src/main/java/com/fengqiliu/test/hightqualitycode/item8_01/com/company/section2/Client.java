package com.fengqiliu.test.hightqualitycode.item8_01.com.company.section2;

import java.io.FileNotFoundException;

public class Client {
	public static void main(String[] args) {
		
	}
	
	public void doStuff(){
		try{
			//do something
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//	
//	public void doStuff2(){
//		try{
//			//do something
//		}catch(FileNotFoundException e){
//			log.info("文件问找到，使用默认配置文件……");
//		}catch(SecurityException e){
//			log.error("无权访问，可能原因是……");
//			e.printStackTrace();
//		}
//	}
}
