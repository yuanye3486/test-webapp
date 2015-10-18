package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * @author LiuFengqi
 * @ClassName: BubbleSort
 * @Description: 冒泡排序算法的一种实现
 * @date 2013-11-2 上午10:42:25
 */
public class BubbleSort extends Sortable {

    public static final String NAME = "冒泡排序(Bubble Sort)";

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        int count = 0;
        for (int i = 1; i < unsortedSequence.length - 1; i++) {
            for (int j = 1; j < unsortedSequence.length - i; j++) {
                if (unsortedSequence[j] < unsortedSequence[j + 1]) {
                    int temp;
                    temp = unsortedSequence[j];
                    unsortedSequence[j] = unsortedSequence[j + 1];
                    unsortedSequence[j + 1] = temp;
                }
            }
            messageBuffer.append("第 ").append(++count).append(" 趟： ")
                    .append(Util.intArrayToString(unsortedSequence)).append("\n");
            messagePane.setText(messageBuffer.toString());
        }
        return unsortedSequence;
    }

}
