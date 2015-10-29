package com.fengqiliu.test.hightqualitycode.item11_03.com.company.section3;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Client {
	public static void main(String[] args) {
		//当前时间戳
		DateTime dt = new DateTime();
		//此时伦敦是的时间
		System.out.println(dt.withZone(DateTimeZone.forID("Europe/London")));
		//计算出标准时间
		System.out.println(dt.withZone(DateTimeZone.UTC));

	}
}
