package com.fengqiliu.test.java;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClassTest {
    private Boolean b;

    public static void main(String[] args) {
        ClassTest ct = new ClassTest();
        ct.getResource();

    }

    public void getResource() {
        String path = FileUtils.class.getResource("/").getPath();
        String path2 = StringUtils.class.getClassLoader().getResource("").getFile();
        String path3 = ClassTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(path);
        System.out.println(path2);
        System.out.println(path3);
    }

    public void getSimpleName() {
        System.out.println(this.getClass().getSimpleName());
    }

    public void getName() {
        System.out.println(this.getClass().getName());
    }

    public Boolean getB() {
        return b;
    }

    public void setB(Boolean b) {
        this.b = b;
    }

    public void test() {
        ClassTest ct = new ClassTest();
        ct.getSimpleName();
        ct.getName();

        Field[] fields = ct.getClass().getDeclaredFields();

        for (Field f : fields) {
            System.out.println(f.getName() + " = " + f.getType().getName());
        }
    }
}
