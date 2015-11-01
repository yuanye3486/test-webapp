package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * 折半插入排序
 *
 * @author LiuFengqi
 * @ClassName: BinaryInsertionSort
 * @Description: 时间复杂度O()
 * @date 2013-11-12 下午3:37:20
 */
public class BinaryInsertionSort extends Sortable {

    public static final String NAME = "折半插入排序(Binary Insertion Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        this.messagePane = messagePane;
        binaryInsertionSort(unsortedSequence);
        return unsortedSequence;
    }

    private void binaryInsertionSort(int[] unsortedSequence) {
        for (int i = 2; i <= unsortedSequence.length - 1; i++) {
            unsortedSequence[0] = unsortedSequence[i];
            int low = 1, hight = i - 1;
            while (low <= hight) {
                int middle = (low + hight) / 2;    // 折半
                if (unsortedSequence[0] < unsortedSequence[middle]) {   //	插入点在低半区
                    hight = middle - 1;
                } else {   //插入点在高半区
                    low = middle + 1;
                }
            }

            for (int j = i - 1; j >= hight + 1; j--) {   //记录后移
                unsortedSequence[j + 1] = unsortedSequence[j];
            }

            unsortedSequence[hight + 1] = unsortedSequence[0];    // 插入

            messageBuffer.append("第 ").append(++count).append(" 趟： ")
                    .append(Util.intArrayToString(unsortedSequence)).append("\n");
            messagePane.setText(messageBuffer.toString());
        }
    }
}
