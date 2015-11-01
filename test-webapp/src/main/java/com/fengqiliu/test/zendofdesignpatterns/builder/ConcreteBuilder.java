package com.fengqiliu.test.zendofdesignpatterns.builder;

/**
 * Created by LiuFengqi on 2015/9/14.
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();

    @Override
    public void setPart() {
        System.out.println("装配零件，组装产品...");
    }

    @Override
    public Product buildProduct() {
        System.out.println("建造产品...");
        return product;
    }
}
