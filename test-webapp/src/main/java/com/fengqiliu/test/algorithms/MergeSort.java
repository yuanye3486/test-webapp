package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * 合并排序法基本是将两笔已排序的资料合并并进行排序，如果所读入的资料尚未排序，
 * 可以先利用其它的排序方式来处理这两笔资料，然后再将排序好的这两笔资料合并。
 * Created by LiuFengqi on 2015/10/6.
 */
public class MergeSort extends Sortable {
    public static final String NAME = "合并排序(Merge Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {


        return unsortedSequence;
    }
}
