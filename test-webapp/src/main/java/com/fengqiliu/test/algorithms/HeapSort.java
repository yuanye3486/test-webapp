package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * Created by LiuFengqi on 2015/10/6.
 */
public class HeapSort extends Sortable {
    public static final String NAME = "堆排序(Heap Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        int itemCount = unsortedSequence.length;
        int i, m, p, s, temp;
        int number_temp[] = new int[itemCount + 1];
        for (int temp_i = 1; temp_i < itemCount + 1; temp_i++) {
            number_temp[temp_i] = unsortedSequence[temp_i - 1];
        }
        createHeap(number_temp);
        m = itemCount;
        while (m > 1) {
            temp = number_temp[1];
            number_temp[1] = number_temp[m];
            number_temp[m] = temp;
            m--;
            p = 1;
            s = 2 * p;
            while (s <= m) {
                if (s < m && number_temp[s + 1] > number_temp[s])
                    s++;
                if (number_temp[p] >= number_temp[s])
                    break;
                temp = number_temp[p];
                number_temp[p] = number_temp[s];
                number_temp[s] = temp;
                p = s;
                s = 2 * p;
            }
        }
        for (int temp_j = 1; temp_j < itemCount + 1; temp_j++) {
            unsortedSequence[temp_j - 1] = number_temp[temp_j];
        }
        return unsortedSequence;
    }

    /**
     * 将原数组构造为从下标1开始的一个新数组，便于处理，同时将这个新数组构造为最初始的堆积树结构
     *
     * @param
     */
    private void createHeap(int number[]) {
        int itemCount = number.length;
        int i, s, p, temp;
        int heap[] = new int[itemCount + 1];
        for (i = 1; i <= itemCount; i++) {
            heap[i] = number[i];
            s = i;
            p = i / 2;
            while (s >= 2 && heap[p] < heap[s]) {
                temp = heap[p];
                heap[p] = heap[s];
                heap[s] = temp;
                s = p;
                p = s / 2;
            }
        }
        for (i = 1; i <= itemCount; i++) {
            number[i] = heap[i];
        }
    }
}
