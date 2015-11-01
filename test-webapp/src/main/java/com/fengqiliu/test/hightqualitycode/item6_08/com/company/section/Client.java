package com.fengqiliu.test.hightqualitycode.item6_08.com.company.section;

import java.lang.annotation.*;

// 鸟巢，工厂方法模式
enum BirdNest {
    Sparrow;

    // 鸟类繁殖
    public Bird reproduce() {
        Desc bd = Sparrow.class.getAnnotation(Desc.class);
        return bd == null ? new Sparrow() : new Sparrow(bd.c());
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@interface Desc {
    // 默认颜色是白色的
    Color c() default Color.White;

    enum Color {
        White, Grayish, Yellow;
    }
}

public class Client {
    // 模拟业务调用
    public static void main(String[] args) {
        Bird bird = BirdNest.Sparrow.reproduce();
        Desc.Color color = bird.getColor();
        System.out.println("Bird's color is: " + color);
    }
}

// 鸟的抽象类
@Desc(c = Desc.Color.White)
abstract class Bird {
    // 鸟的颜色
    public abstract Desc.Color getColor();
}

// 麻雀
class Sparrow extends Bird {
    private Desc.Color color;

    // 默认是浅灰色
    public Sparrow() {
        color = Desc.Color.Grayish;
    }

    // 构造函数定义鸟的颜色
    public Sparrow(Desc.Color _color) {
        color = _color;
    }

    @Override
    public Desc.Color getColor() {
        return color;
    }
}