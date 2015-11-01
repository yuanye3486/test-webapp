package com.fengqiliu.test.java;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendarTest {
    private static final Calendar cal = Calendar.getInstance();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {


//		testWeek();
        testAdd();

    }

    public static void testWeek() {
        cal.setTime(new Date());
        System.out.println("first day of week = " + cal.getFirstDayOfWeek());
        cal.set(Calendar.MONTH, 1);
        System.out.println(sdf.format(cal.getTime()));
    }


    public static void testAdd() throws InterruptedException {
        Date date = new Date();

        System.out.println("当前时间：" + sdf.format(date));

        cal.setTime(date);

        cal.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("当前时间+1天：" + sdf.format(cal.getTime()));

        cal.add(Calendar.WEEK_OF_MONTH, 1);
        System.out.println("再加+1周：" + sdf.format(cal.getTime()));

        cal.add(Calendar.WEEK_OF_YEAR, 1);
        System.out.println("再加+1周：" + sdf.format(cal.getTime()));

        cal.add(Calendar.MONTH, 1);
        System.out.println("再加+1月：" + sdf.format(cal.getTime()));

        System.out.println("当前时间：" + sdf.format(cal.getTime()));
    }

}

