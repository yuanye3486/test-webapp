package com.fengqiliu.test.hightqualitycode.item11_02.com.company.section7;


public class User {
    private String name;
    private int age;

    public User(String _name, int _age) {
        name = _name;
        age = _age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}