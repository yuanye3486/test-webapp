package com.fengqiliu.test.hightqualitycode.item8_05.com.company.section2;

import java.io.IOException;

public class Client {
	public static void main(String[] args) {
		try{
			Base base = new Base();
		}catch(IOException e){
			//异常处理
		}
	}
}

class Base{
	//父类抛出IOException
	public Base() throws IOException{
		throw new IOException();
	}
	//父类方法抛出Exception
	public void method() throws Exception{
		
	}
}

class Sub extends Base{
	//子类抛出Exception异常
	public Sub() throws Exception {
	}
	//子类方法的异常类型必须是覆写方法的子类型
	@Override
	public void method() throws IOException{
		
	}
}
