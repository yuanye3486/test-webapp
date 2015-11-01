package com.fengqiliu.test.java;

import java.lang.reflect.Field;


public class ClassTest {
    private Boolean b;

    public static void main(String[] args) {
        ClassTest ct = new ClassTest();
        Field[] fields = ct.getClass().getDeclaredFields();

        for (Field f : fields) {
            System.out.println(f.getName() + " = " + f.getType().getName());
        }

    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

}
