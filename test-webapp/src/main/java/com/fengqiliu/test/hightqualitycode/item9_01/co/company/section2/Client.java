package com.fengqiliu.test.hightqualitycode.item9_01.co.company.section2;

public class Client {
    public static void main(String[] args) throws InterruptedException {

    }
}


class MultiThread extends Thread {
    @Override
    public void start() {
        super.start();
        /*其他业务处理，但是不能调用run方法*/
    }

    @Override
    public void run() {
        //MultiThread do something.
    }
}