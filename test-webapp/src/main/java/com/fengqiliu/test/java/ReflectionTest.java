package com.fengqiliu.test.java;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/11/24.
 */
public class ReflectionTest {

    public static void main(String[] args) throws IllegalAccessException {
//        long startTime = System.nanoTime();
//        testFieldReflect();
//        long endTime = System.nanoTime();
//        System.out.println("耗时：" + (endTime - startTime) + "纳秒。");


        for (Method m : ReflectionTest.class.getDeclaredMethods()) {
            if (m.getName().contains("testMethod")) {
                Class[] mp = m.getParameterTypes();
                mp[0].getName();
                Class bc = Boolean.class;
                bc.getName();
                System.out.println(mp[0].getName());
                System.out.println(mp[0].isInstance(Boolean.FALSE));
                System.out.println(mp[0].isPrimitive());
                System.out.println(bc.isInstance(Boolean.FALSE));
                System.out.println(bc.isInstance(true));
            }
        }
    }

    public void testMethod(boolean p1) {

    }


    public static void testFieldReflect() throws IllegalAccessException {
        Bean obj = new Bean();
        Field[] fields = obj.getClass().getDeclaredFields();
        if (fields.length == 0) {
            System.out.println(ReflectionTest.class.getName() + " 不包含任何字段！");
        }
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }

            Object fieldVal = field.get(obj);
            if (fieldVal != null && fieldVal instanceof Number) {
                System.out.println(field.getName() + " is instanceof Number. value is " + fieldVal.toString());
            }
        }

    }
}

class Bean {
    private Integer integerStaticField = 1;

    private Integer integerField = 2;
    private int intField = 3;


}