package com.fengqiliu.test.algorithm;

/**
 * @athor liufengqi
 * @date 2016/6/22
 * @since 2.0
 */
public class HeapSort {

    /*
         输入：数组A，堆的长度hLen，以及需要调整的节点i
        功能：调堆
    */

    void AdjustHeap(int A[], int hLen, int i)
    {
        int left = 0; //LeftChild(i);  //节点i的左孩子
        int right = 0; //RightChild(i); //节点i的右孩子节点
        int largest = i;
        int temp;

        while(left < hLen || right < hLen)
        {
            if (left < hLen && A[largest] < A[left])
            {
                largest = left;
            }

            if (right < hLen && A[largest] < A[right])
            {
                largest = right;
            }

            if (i != largest)   //如果最大值不是父节点
            {
                temp = A[largest]; //交换父节点和和拥有最大值的子节点交换
                A[largest] = A[i];
                A[i] = temp;

                i = largest;         //新的父节点，以备迭代调堆
                left = 0; //LeftChild(i);  //新的子节点
                right = 0; //RightChild(i);
            }
            else
            {
                break;
            }
        }
    }

    /*
        输入：数组A，堆的大小hLen
        功能：建堆
    */
    void BuildHeap(int A[], int hLen)
    {
        int i;
        int begin = hLen/2 - 1;  //最后一个非叶子节点
        for (i = begin; i >= 0; i--)
        {
            AdjustHeap(A, hLen, i);
        }
    }

    /*
        输入：数组A，待排序数组的大小aLen
        功能：堆排序
    */
    void HeapSort(int A[], int aLen)
    {
        int hLen = aLen;
        int temp;

        BuildHeap(A, hLen);      //建堆

        while (hLen > 1)
        {
            temp = A[hLen-1];    //交换堆的第一个元素和堆的最后一个元素
            A[hLen-1] = A[0];
            A[0] = temp;
            hLen--;        //堆的大小减一
            AdjustHeap(A, hLen, 0);  //调堆
        }
    }
}
