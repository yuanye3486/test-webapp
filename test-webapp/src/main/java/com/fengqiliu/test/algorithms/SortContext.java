package com.fengqiliu.test.algorithms;

import javax.swing.*;

public class SortContext {
    public static final String[] SORTER_NAMES = new String[]{BubbleSort.NAME,
            QuickSort.NAME, ShellSort.NAME, StraightInsertSort.NAME, BinaryInsertionSort.NAME,
            BaseSort.NAME, SelectSort.NAME, HeapSort.NAME, MergeSort.NAME};
    private Sortable sorter; // 排序器
    private int[] unsortedSequence; // 未排序前的序列
    private int[] sortedSequence; // 排序后的序列
    private JTextPane messagePane; // 用于显示排序过程的具体信息

    public SortContext(Sortable sorter, int[] unsortedSequence,
                       JTextPane messagePane) {
        this.sorter = sorter;
        this.unsortedSequence = unsortedSequence;
        this.messagePane = messagePane;
    }

    /**
     * 获取排序结果。
     *
     * @return
     */
    public int[] getSortResult() {
        sortedSequence = sorter.sort(unsortedSequence, messagePane);
        return sortedSequence;
    }

    public int[] getSortedSequence() {
        return sortedSequence;
    }

}
