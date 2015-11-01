package com.fengqiliu.test.hightqualitycode.item4_08.com.company.section3;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class Client {
    public static void main(String[] args) throws Exception {
        String[] strs = {"�(B)", "鑫(X)"};
        Arrays.sort(strs, Collator.getInstance(Locale.CHINA));
        int i = 0;
        for (String str : strs) {
            System.out.println((++i) + "、" + str);
        }

    }

}
