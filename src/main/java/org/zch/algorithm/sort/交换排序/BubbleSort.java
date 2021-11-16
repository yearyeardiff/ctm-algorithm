/**
 * $Id: BubbleSort.java,v 1.0 2018/2/1 17:46 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.交换排序;

/**
 * $Id: BubbleSort.java,v 1.0 2018/2/1 17:46 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
public class BubbleSort {
    /**
     * 从小到大
     *
     * @param numbers
     */
    public static void bubble_sort(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 从小到大
     *
     * @param numbers
     */
    public static void bubble_sort2(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    flag = 1;
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
            if (flag == 0) {//没有交换：已经有序了
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 111, 33, 55, 6};
        bubble_sort(arr);
    }
}
