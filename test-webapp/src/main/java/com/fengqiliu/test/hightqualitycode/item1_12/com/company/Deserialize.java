package com.fengqiliu.test.hightqualitycode.item1_12.com.company;

/**
 * 序列化类避免在构造函数中为不变量赋值
 */
public class Deserialize {
    public static void main(String[] args) {
        //反序列化
        Person p = (Person) SerializationUtils.readObject();

        System.out.println(p.name);
    }
}
