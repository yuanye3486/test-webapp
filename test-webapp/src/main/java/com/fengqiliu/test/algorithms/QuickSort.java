package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * 快速排序
 *
 * @author LiuFengqi
 * @ClassName: QuickSort
 * @Description: 时间复杂度O(n^)
 * @date 2013-11-12 下午2:33:41
 */
public class QuickSort extends Sortable {

    public static final String NAME = "快速排序(Quick Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        this.messagePane = messagePane;
        quickSort(unsortedSequence, 1, unsortedSequence.length - 1);
        return unsortedSequence;
    }

    /**
     * 对 unsortedSequence 中的子序列 unsortedSequence[low..high] 作快速排序。
     *
     * @param unsortedSequence
     * @param low
     * @param high
     */
    private void quickSort(int[] unsortedSequence, int low, int high) {
        if (low < high) {
            int pviotloc = partition(unsortedSequence, low, high);
            quickSort(unsortedSequence, low, pviotloc - 1);
            quickSort(unsortedSequence, pviotloc + 1, high);
        }
    }

    /**
     * 交换顺序表 unsortedSequence 中子表 unsortedSequence[low..high]
     * 的记录，枢轴记录到位，并返回其所在位置，此时在它之前的（后）的记录均不大（小）于它。
     *
     * @param unsortedSequence
     * @param low
     * @param high
     * @return 返回枢轴记录的当前位置
     */
    private int partition(int[] unsortedSequence, int low, int high) {
        unsortedSequence[0] = unsortedSequence[low];    //	用子表的第一个记录作为枢轴记录
        int pivotkey = unsortedSequence[low]; // 枢轴记录关键字

        while (low < high) {   //从表的两端交替地向中间扫描
            while (low < high && unsortedSequence[high] >= pivotkey) {
                --high;
            }
            unsortedSequence[low] = unsortedSequence[high];    //	将比枢轴记录小的记录移到低端

            while (low < high && unsortedSequence[low] <= pivotkey) {
                ++low;
            }
            unsortedSequence[high] = unsortedSequence[low];    //	将比枢轴记录大的记录移到高端
        }

        unsortedSequence[low] = unsortedSequence[0];    //	枢轴记录到位

        messageBuffer.append("第 ").append(++count).append(" 趟： ")
                .append(Util.intArrayToString(unsortedSequence)).append("\n");
        messagePane.setText(messageBuffer.toString());

        return low;    //	返回枢轴位置
    }

}
