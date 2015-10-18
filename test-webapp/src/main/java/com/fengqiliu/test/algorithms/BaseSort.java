package com.fengqiliu.test.algorithms;

import javax.swing.*;

/**
 * 基数排序的方式可以采用LSD（Least sgnificant digital）或MSD（Most sgnificant digital），
 * LSD的排序方式由键值的最右边开始，而MSD则相反，由键值的最左边开始。
 * 以LSD为例，假设原来有一串数值如下所示：
 * 73, 22, 93, 43, 55, 14, 28, 65, 39, 81
 * 首先根据个位数的数值，在走访数值时将它们分配至编号0到9的桶子中：
 * 0   1   2   3   4   5   6   7   8   9
 * 81              65              39
 * 43  14  55          28
 * 93
 * 22  73
 * 接下来将这些桶子中的数值重新串接起来，成为以下的数列：
 * 81, 22, 73, 93, 43, 14, 55, 65, 28, 39
 * 接着再进行一次分配，这次是根据十位数来分配：
 * 接下来将这些桶子中的数值重新串接起来，成为以下的数列：
 * 0   1   2   3   4   5   6   7   8   9
 * 28  39
 * 14  22      43  55  65  73  81  93
 * 14, 22, 28, 39, 43, 55, 65, 73, 81, 93
 * 这时候整个数列已经排序完毕；如果排序的对象有三位数以上，则持续进行以上的动作直至最
 * 高位数为止。
 * LSD的基数排序适用于位数小的数列，如果位数多的话，使用MSD的效率会比较好，MSD的方
 * 式恰与LSD相反，是由高位数为基底开始进行分配，其他的演算方式则都相同。
 * Created by LiuFengqi on 2015/10/6.
 */
public class BaseSort extends Sortable {
    public static final String NAME = "基数排序(Base Sort)";
    private JTextPane messagePane;
    private int count = 0;

    @Override
    public int[] sortHandle(int[] unsortedSequence, JTextPane messagePane) {
        int itemCount = unsortedSequence.length;
        int temp[][] = new int[itemCount][itemCount];
        int order[] = new int[itemCount];
        int i, j, k, n, lsd;
        k = 0;
        n = 1;

        while (n <= 10) {
            for (i = 0; i < itemCount; i++) {
                lsd = ((unsortedSequence[i] / n) % 10);
                temp[lsd][order[lsd]] = unsortedSequence[i];
                order[lsd]++;
            }
            //重新排列
            for (i = 0; i < itemCount; i++) {
                if (order[i] != 0)
                    for (j = 0; j < order[i]; j++) {
                        unsortedSequence[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }
        return unsortedSequence;
    }
}
