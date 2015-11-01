package com.fengqiliu.test.hightqualitycode.item3_18.com.company.section2;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

    public static void main(String[] args) {
        // Person类的实例作为Map的key

        Map<Person, Object> map = new HashMap<Person, Object>() {
            {
                put(new Person("张三"), new Object());
            }
        };
        // Person类的实例作为List的元素
        List<Person> list = new ArrayList<Person>() {
            {
                add(new Person("张三"));
            }
        };

        // 列表中是否包含
        boolean b1 = list.contains(new Person("张三"));
        // Map中是否包含
        boolean b2 = map.containsKey(new Person("张三"));
        System.out.println(b2);
    }
}

class Person {
    private String name;

    public Person(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            Person p = (Person) obj;
            if (p.getName() == null && name == null) {
                return false;
            } else {
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }
}
