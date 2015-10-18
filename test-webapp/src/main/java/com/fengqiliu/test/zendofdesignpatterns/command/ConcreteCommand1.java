package com.fengqiliu.test.zendofdesignpatterns.command;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class ConcreteCommand1 extends Command {
    //对哪个Receiver类进行命令处理
    private Receiver receiver;

    //构造函数传递接收者
    public ConcreteCommand1(Receiver _receiver) {
        this.receiver = _receiver;
    }//必须实现一个命令

    public void execute() {
    //业务处理
        this.receiver.doSomething();
    }
}