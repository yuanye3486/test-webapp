package com.fengqiliu.test.hightqualitycode.item11_03.com.company.section1;

import org.joda.time.DateTime;

import java.util.Locale;

public class Client {
    public static void main(String[] args) {
        //当前时间戳
        DateTime dt = new DateTime();
        //输出英文星期
        System.out.println(dt.dayOfWeek().getAsText(Locale.ENGLISH));
        //本地日期格式
        System.out.println(dt.toLocalDate());
    }
}
