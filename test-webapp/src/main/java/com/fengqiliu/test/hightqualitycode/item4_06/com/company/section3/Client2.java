package com.fengqiliu.test.hightqualitycode.item4_06.com.company.section3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client2 {
    public static void main(String[] args) {
        String c = "But I'm not dead yet!";
        Pattern pattern = Pattern.compile("[ [']]");
        Matcher matcher = pattern.matcher(c);
        for (String str : pattern.split(c)) {
            System.out.println(str);
        }
    }
}
