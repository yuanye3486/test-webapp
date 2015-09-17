package com.fengqiliu.test.zendofdesignpatterns.builder;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public abstract class Builder {
    /**
     * 设置产品的不同部分， 以获得不同的产品
     */
    public abstract void setPart();

    /**
     * 建造产品
     */
    public abstract Product buildProduct();
}
