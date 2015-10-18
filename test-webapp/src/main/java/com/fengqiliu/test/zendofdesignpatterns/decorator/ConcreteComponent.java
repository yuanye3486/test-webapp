package com.fengqiliu.test.zendofdesignpatterns.decorator;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class ConcreteComponent extends Component {
    //具体实现
    @Override
    public void operate() {
        System.out.println("do Something");
    }
}