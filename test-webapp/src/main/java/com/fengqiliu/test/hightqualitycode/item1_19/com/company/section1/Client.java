package com.fengqiliu.test.hightqualitycode.item1_19.com.company.section1;

/**
 * 断言不能用在输入判断上
 */
public class Client {
    public static void main(String[] args) {
        StringUtils.encode(null);
    }

}

//字符串处理工具类
class StringUtils {
    public static String encode(String str) {
        assert str != null : "加密的字符串为null";
        /*加密处理*/
        return null;
    }
}
