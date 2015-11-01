package com.fengqiliu.test.hightqualitycode.item4_02.com.company;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StringUtilsTest {
    @Test
    public void testRemove() {
        System.out.println(StringUtils.remove("$是$", "$"));
        assertTrue(StringUtils.remove("$是$", "$").equals("是"));
    }
}
