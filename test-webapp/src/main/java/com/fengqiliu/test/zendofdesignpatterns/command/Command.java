package com.fengqiliu.test.zendofdesignpatterns.command;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public abstract class Command {
    //每个命令类都必须有一个执行命令的方法
    public abstract void execute();
}
