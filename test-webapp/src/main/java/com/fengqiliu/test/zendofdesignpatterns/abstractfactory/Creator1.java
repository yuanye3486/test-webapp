package com.fengqiliu.test.zendofdesignpatterns.abstractfactory;

/**
 * Created by LiuFengqi on 2015/9/13.
 */
public class Creator1 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
