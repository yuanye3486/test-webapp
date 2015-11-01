package com.fengqiliu.test.hightqualitycode.item5_22.com.company;

import java.util.SortedSet;
import java.util.TreeSet;

public class Client {
    public static void main(String[] args) {
        SortedSet<Person> set = new TreeSet<Person>();
        //身高180CM
        set.add(new Person(180));
        //身高175CM
        set.add(new Person(175));

        for (Person p : set) {
            System.out.println("身高:" + p.getHeight());
        }
    }

    static class Person implements Comparable<Person> {
        //身高
        private int height;

        public Person(int _age) {
            height = _age;
        }


        public int getHeight() {
            return height;
        }


        public void setHeight(int height) {
            this.height = height;
        }

        //按照身高排序
        public int compareTo(Person o) {
            return height - o.height;
        }

    }
}

