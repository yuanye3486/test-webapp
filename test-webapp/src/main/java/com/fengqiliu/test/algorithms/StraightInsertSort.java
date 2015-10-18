package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * 直接插入排序
 *
 * @author LiuFengqi
 * @ClassName: StraightInsertSort
 * @Description: 时间复杂度 O(n^2)
 * @date 2013-11-12 下午2:32:00
 */
public class StraightInsertSort extends Sortable {

    public static final String NAME = "直接插入排序(Straight Insertion Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        this.messagePane = messagePane;
        straightInsertSort(unsortedSequence);
        return unsortedSequence;
    }

    /**
     * 直接插入排序
     *
     * @param unsortedSequence 待排序数组
     */
    private void straightInsertSort(int[] unsortedSequence) {
        for (int i = 2; i <= unsortedSequence.length - 1; i++) {
            if (unsortedSequence[i] < unsortedSequence[i - 1]) {
                unsortedSequence[0] = unsortedSequence[i];    // 复制为哨兵
                unsortedSequence[i] = unsortedSequence[i - 1];

                int j = i - 2;
                for (; unsortedSequence[0] < unsortedSequence[j]; --j) {
                    unsortedSequence[j + 1] = unsortedSequence[j];    //	记录后移
                }
                unsortedSequence[j + 1] = unsortedSequence[0];    // 插入到正确位置
            }

            messageBuffer.append("第 ").append(++count).append(" 趟： ")
                    .append(Util.intArrayToString(unsortedSequence)).append("\n");
            messagePane.setText(messageBuffer.toString());
        }
    }

}
