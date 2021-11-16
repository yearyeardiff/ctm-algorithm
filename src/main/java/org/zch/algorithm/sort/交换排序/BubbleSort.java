/**
 * $Id: BubbleSort.java,v 1.0 2018/2/1 17:46 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.��������;

/**
 * $Id: BubbleSort.java,v 1.0 2018/2/1 17:46 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
public class BubbleSort {
    /**
     * ��С����
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
     * ��С����
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
            if (flag == 0) {//û�н������Ѿ�������
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 111, 33, 55, 6};
        bubble_sort(arr);
    }
}
