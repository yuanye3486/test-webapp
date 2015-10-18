package com.fengqiliu.test.zendofdesignpatterns.prototype;

/**
 * Created by LiuFengqi on 2015/10/3.
 */
public class PrototypeClass implements Cloneable {

    @Override
    public PrototypeClass clone() {
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototypeClass;
    }
}
