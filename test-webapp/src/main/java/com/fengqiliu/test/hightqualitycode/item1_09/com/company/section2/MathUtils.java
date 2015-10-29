package com.fengqiliu.test.hightqualitycode.item1_09.com.company.section2;
import static java.lang.Math.PI;;
/**
 * 静态导入
 *
 */
public class MathUtils{
	//计算圆面积
	public static double calCircleArea(double r){
		return PI * r * r;
	}
	
	//计算球面积
	public static double calBallArea(double r){
		return 4 * PI * r * r;
	}
}
