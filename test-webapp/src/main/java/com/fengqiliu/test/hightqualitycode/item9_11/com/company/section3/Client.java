package com.fengqiliu.test.hightqualitycode.item9_11.com.company.section3;


public class Client {

    public static void main(String[] args) {
        new Thread(new Foo()).start();
    }

}

class Foo implements Runnable {
    @Override
    public void run() {
        method1();
    }

    public synchronized void method1() {
        method2();
    }

    public synchronized void method2() {
        //Do Something
    }

}
