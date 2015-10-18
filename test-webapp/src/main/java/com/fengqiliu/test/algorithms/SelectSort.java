package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * 将要排序的对象分作两部份，一个是已排序的，一个是未排序的，从后端未排序部份选择一个最小值，并放入前端已排序部份的最后一个。
 * Created by LiuFengqi on 2015/10/6.
 */
public class SelectSort extends Sortable {
    public static final String NAME = "选择排序(Select Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        int itemCount = unsortedSequence.length;
        int i, j, k, m, temp;
        for (i = 0; i < itemCount - 1; i++) {
            m = i;
            for (j = i + 1; j < itemCount; j++) {
                if (unsortedSequence[j] < unsortedSequence[m]) {
                    m = j;
                }
            }
            if (i != m) {
                temp = unsortedSequence[i];
                unsortedSequence[i] = unsortedSequence[m];
                unsortedSequence[m] = temp;
            }
        }
        return unsortedSequence;
    }
}
