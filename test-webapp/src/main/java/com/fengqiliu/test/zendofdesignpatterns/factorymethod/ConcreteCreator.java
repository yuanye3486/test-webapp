package com.fengqiliu.test.zendofdesignpatterns.factorymethod;

/**
 * Created by LiuFengqi on 2015/9/13.
 */
public class ConcreteCreator extends Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> obj) {
        Product product = null;
        if (null != obj) {
            try {
                product = (Product) Class.forName(obj.getName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (T) product;
    }
}
