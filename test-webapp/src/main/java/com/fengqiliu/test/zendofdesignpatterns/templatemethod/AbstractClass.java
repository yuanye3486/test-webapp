package com.fengqiliu.test.zendofdesignpatterns.templatemethod;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public abstract class AbstractClass {
    protected abstract void doAnything();

    protected abstract void doSomething();

    public void templateMethod() {
        doAnything();
        doSomething();
    }
}
