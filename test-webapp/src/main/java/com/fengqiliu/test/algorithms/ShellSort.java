package com.fengqiliu.test.algorithms;

import javax.swing.*;

public class ShellSort extends Sortable {

    public static final String NAME = "希尔排序(Shell Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        this.messagePane = messagePane;
//		shellSort(unsortedSequence, , );
        return unsortedSequence;
    }

    /**
     * Shell首先将间隔设定为n/2，然后跳跃进行插入排序，再来将间隔n/4，跳跃进行排序动作，再来
     * 间隔设定为n/8、n/16，直到间隔为1之后的最后一次排序终止，由于上一次的排序动作都会将
     * 固定间隔内的元素排序好，所以当间隔越来越小时，某些元素位于正确位置的机率越高，因此
     * 最后几次的排序动作将可以大幅减低。
     *
     * @param unsortedSequence 待排序序列
     * @param dk               增量
     */
    private void shellInsert(int[] unsortedSequence, int dk) {
        int i, j, k, gap, temp;
        gap = unsortedSequence.length / 2;
        while (gap > 0) {
            for (k = 0; k < gap; k++) {
                for (i = k + gap; i < unsortedSequence.length; i += gap) {
                    for (j = i - gap; j >= k; j -= gap) {
                        if (unsortedSequence[j] > unsortedSequence[j + gap]) {
                            temp = unsortedSequence[j];
                            unsortedSequence[j] = unsortedSequence[j + gap];
                            unsortedSequence[j + gap] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            gap /= 2;
        }
    }

    /**
     * @param unsortedSequence 待排序序列
     * @param dlta             增量序列
     * @param t
     */
    private void shellSort(int[] unsortedSequence, int[] dlta, int t) {
        for (int k = 0; k < t; k++) {
            shellInsert(unsortedSequence, dlta[k]);    //	一趟增量为dlta[k]的插入排序
        }
    }
}
