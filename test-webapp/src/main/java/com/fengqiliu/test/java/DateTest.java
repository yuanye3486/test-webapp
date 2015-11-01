package com.fengqiliu.test.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
//		Date date = sdf.parse("2015-05-16 12:00:00");
//		
//		changeDate(date);
//		System.out.println(date);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		changeCalendar(cal);
//		System.out.println(cal.getTime());
//		
//		getTimeDifference();

        getUnixTimestamp(new Date());
    }

    private static void getUnixTimestamp(Date date) {
        System.out.println(date.getTime() / 1000);
    }

    private static void changeCalendar(Calendar cal) {
        cal.setTime(new Date());
    }

    private static void changeDate(Date date) {
        date = new Date();
    }

    private static void getTimeDifference() throws ParseException {
        Date date1 = sdf.parse("2015-05-16 00:00:00");
        Date date2 = sdf.parse("2015-05-18 00:00:00");

        long hours = (date2.getTime() - date1.getTime()) / 3600000;
        System.out.println("相差小时数L：" + (636 - (hours + 1)));
        System.out.println("相差小时数R：" + (hours + 1));
    }
}