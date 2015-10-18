package com.fengqiliu.test.zendofdesignpatterns.command;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class Client {
    public static void main(String[] args) {
        //首先声明调用者Invoker
        Invoker invoker = new Invoker();
        //定义接收者
        Receiver receiver1 = new ConcreteReceiver1();
        //定义一个发送给接收者的命令
        Command command1 = new ConcreteCommand1(receiver1);
        //定义接收者
        Receiver receiver2 = new ConcreteReceiver2();
        //定义一个发送给接收者的命令
        Command command2 = new ConcreteCommand1(receiver2);

        //把命令交给调用者去执行
        invoker.setCommand(command1);
        invoker.action();

        invoker.setCommand(command2);
        invoker.action();
    }
}