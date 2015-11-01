package com.fengqiliu.test.hightqualitycode.item12_05.com.company.section1;

//枪
interface Gun {
    // 枪用来干什么的？射击杀戮！
    public void shoot();
}

public class Client {
    public static void main(String[] args) {
        Gun gun = new Handgun();
        gun.shoot();
    }
}

//手枪
class Handgun implements Gun {
    @Override
    public void shoot() {
        System.out.println("手枪射击...");
    }
}

//玩具枪
class ToyGun implements Gun {
    @Override
    public void shoot() {
        // 玩具枪不能射击，这个方法就不实现了
    }
}
