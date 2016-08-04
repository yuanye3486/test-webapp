package com.fengqiliu.test.algorithm;

/**
 * @athor liufengqi
 * @date 2016/7/12
 */
public class QuickSort2 {
    private static int[] data;

    private static void swap(int source, int target) {
        int temp = data[source];
        data[source] = data[target];
        data[target] = temp;
    }

    private static void partition(int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end-1;
        int pivot = data[end];
        while (left < right) {
            while (left < right && data[left] <= pivot) {
                left++;
            }
            while (left < right && data[right] >= pivot) {
                right--;
            }
            swap(left, right);
        }
        if (data[left] > data[end]) {
            swap(left,end);
        }else {
            left++;
        }
        partition(start, left - 1);
        partition(left + 1, end);
    }

    public static void main(String[] args) {
        data = new int[]{121, 23, 34, 56, 767, 54, 66, 8, 989, 2323, 234, 23,511, 77, 454};
        partition(0, data.length-1);
        for (int i : data) {
            System.out.println(i + ", ");
        }
    }
}
