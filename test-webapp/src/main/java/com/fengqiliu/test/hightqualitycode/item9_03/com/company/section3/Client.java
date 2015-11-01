package com.fengqiliu.test.hightqualitycode.item9_03.com.company.section3;


import java.util.Timer;
import java.util.TimerTask;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        final SafeStopThread sst = new SafeStopThread();
        sst.start();
        //0.5秒后线程停止执行
        new Timer(true).schedule(new TimerTask() {
            public void run() {
                sst.terminate();
            }
        }, 500);
    }

}

class SafeStopThread extends Thread {
    //此变量必须加上volatile
    private volatile boolean stop = false;

    @Override
    public void run() {
        //判断线程体是否运行
        while (stop) {
            // Do Something
        }
    }

    //线程终止
    public void terminate() {
        stop = true;
    }
}
