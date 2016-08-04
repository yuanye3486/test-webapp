package com.fengqiliu.test.java;

public class StringTest {

    public static void main(String[] args) {

//		test1();
//		test2();
//		subStringTest();
//        toUpperCase();
//        subString();
//        hashCodeTest();
        startsWith();
    }

    private static void startsWith(){
        String s = "/api/v1/users/login?username=admin&password=admin";
        System.out.println(s.startsWith("/api/v1/users/login"));
    }


    private static void hashCodeTest(){
        int hash1 = "ABCDEa123abc".hashCode();
        int hash2 = "ABCDFB123abc".hashCode();
        System.out.println(hash1);
        System.out.println(hash2);
    }


    private static void subString(){
        String str = "过滤模板=\"RULECAT_交通报项目\",正文及过滤所需字段名=\"IR_CONTENT\";";
        String[] parts = str.split("正文及过滤所需字段名");
        System.out.println(parts[1].substring(parts[1].indexOf("\";")));
    }

    private static void toUpperCase(){
        String str = "你好呀！sfjsadfsa+-*\\//()";
        System.out.println(str.toUpperCase());
    }

    private static void subStringTest() {
        String s = "sf/j/slf2322jl23l323j422aklfaakk";
        System.out.println(s.substring(s.lastIndexOf("/j/"), s.length()));

    }

    private static void test2() {
        String s = "12345678\n";
        System.out.println(s.substring(0, s.length()-2));

    }

    private static void test1() {
        String s = "helloqweoqweq";
        s = s.replace("o", "\n");
        String[] sa = s.split(";");
        for(String ss : sa)
            System.out.println(ss);
        System.out.println(s);

        String pattern = "sfdja*77?jh[jh]";
        String newStr = pattern.replace("*", "\\*").replace("?", "\\?").replace("[", "\\[").replace("]", "\\]");
        System.out.println(newStr);

    }
}
