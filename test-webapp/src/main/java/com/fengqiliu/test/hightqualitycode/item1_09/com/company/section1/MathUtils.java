package com.fengqiliu.test.hightqualitycode.item1_09.com.company.section1;

/**
 * 建议9：少用静态导入
 */
public class MathUtils {
    //计算圆面积
    public static double calCircleArea(double r) {
        return Math.PI * r * r;
    }

    //计算球面积
    public static double calBallArea(double r) {
        return 4 * Math.PI * r * r;
    }
}
