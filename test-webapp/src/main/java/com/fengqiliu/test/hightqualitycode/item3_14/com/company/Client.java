package com.fengqiliu.test.hightqualitycode.item3_14.com.company;

import java.io.Serializable;

public class Client {
    public static void main(String[] args) {
        //定义父亲
        Person f = new Person("父亲");
        //定义大儿子
        Person s1 = new Person("大儿子", f);
        s1.setName("大儿子");

        //小儿子的信息是通过大儿子克隆过来的
        Person s2 = CloneUtils.clone(s1);

        s2.setName("小儿子");
        s1.getFather().setName("干爹");
        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1611293231L;
    //姓名
    private String name;
    //父亲
    private Person father;

    public Person(String _name) {
        name = _name;
    }

    public Person(String _name, Person _parent) {
        name = _name;
        father = _parent;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Person getFather() {
        return father;
    }


    public void setFather(Person father) {
        this.father = father;
    }
}
