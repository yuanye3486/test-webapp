package com.fengqiliu.test.hightqualitycode.item5_11.com.company.section3;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Client {
	public static void main(String[] args) {

		List<Person> list1 = new ArrayList<Person>();
		list1.add(new Person("a"));
		
		List<Person> list2 = new ArrayList<Person>(list1);
		list2.get(0).setName("bbb");
		System.out.println(list1.get(0).getName());
		
	}
}

class Person{
	private String name;
	public Person(String _name){
		name = _name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
