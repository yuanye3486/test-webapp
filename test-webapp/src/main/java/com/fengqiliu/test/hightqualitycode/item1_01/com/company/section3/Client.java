package com.fengqiliu.test.hightqualitycode.item1_01.com.company.section3;

/**
 * 默认值陷阱
 */
public class Client {
    //张三的年龄
    public static Integer ageOfZhangSan;

    public static void main(String[] args) {
        //李四的年龄与张三相同
        int ageOfLiSi = ageOfZhangSan;
        System.out.println("李四的年龄是：" + ageOfLiSi);
    }
}
