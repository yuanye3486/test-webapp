package com.fengqiliu.test.zendofdesignpatterns.builder;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public class Director {
    private Builder builder = new ConcreteBuilder();

    /**
     * 构建不同产品
     *
     * @return
     */
    public Product getAProduct() {
        builder.setPart();
        return builder.buildProduct();
    }

}
