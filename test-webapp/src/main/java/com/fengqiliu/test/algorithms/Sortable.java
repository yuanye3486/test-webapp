package com.fengqiliu.test.algorithms;

import javax.swing.*;

public abstract class Sortable {

    /**
     * 存放排序过程中的排序信息
     */
    StringBuffer messageBuffer = new StringBuffer();

    protected long startTime;
    protected long endTime;

    /**
     * 执行排序算法，并返回排序后的数字序列。
     *
     * @param unsortedSequence
     * @param messagePane
     * @return
     */
    public abstract int[] sortHandle(int[] unsortedSequence, JTextPane messagePane);

    public final int[] sort(int[] unsortedSequence, JTextPane messagePane) {
        int[] sequenceAfterSortedHandle;
        messageBuffer.append("排序前： ").append(Util.intArrayToString(unsortedSequence)).append("\n");
        messagePane.setText(messageBuffer.toString());
        startTime = System.nanoTime();

        sequenceAfterSortedHandle = sortHandle(unsortedSequence, messagePane);

        endTime = System.nanoTime();
        messageBuffer.append("排序元素数：").append(unsortedSequence.length).append("\n");
        messageBuffer.append("总共耗时： ").append(getSortTime() / 1000).append(" ms.\n");
        messagePane.setText(messageBuffer.toString());
        return sequenceAfterSortedHandle;
    }

    /**
     * 获取并返回排序所消耗的时间。
     *
     * @return
     */
    public long getSortTime(){
        return endTime - startTime;
    }
}
