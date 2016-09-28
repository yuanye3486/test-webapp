package com.fengqiliu.test.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by LiuFengqi on 2016/9/27.
 */
public class CuratorTest {
    private static final String HOST_PORT = "192.168.1.139:2181";

    private static final Thread thread1 = new Thread() {
        @Override
        public void run() {
            CuratorUtil curator = new CuratorUtil(HOST_PORT);
            try {
                curator.addWatch("/config", false, watcher1);
                TimeUnit.SECONDS.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private static final Thread thread2 = new Thread() {
        @Override
        public void run() {
            CuratorUtil curator = new CuratorUtil(HOST_PORT);
            String node = "/config/local";
            curator.updateNode(node, "v31311");
            System.out.println(node + " 已修改");
        }
    };

    private static final Watcher watcher1 = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("观察事件：" + event.toString());
        }
    };


    public static void main(String[] args) throws Exception {

        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread2.start();

//        test();
    }


    private static void test() throws Exception {

        CuratorUtil curator = new CuratorUtil(HOST_PORT);
//        curator.createNodeDirect("/config/local", "direct");
        curator.createNode("/config/global/i1", "i1");

    }


}
