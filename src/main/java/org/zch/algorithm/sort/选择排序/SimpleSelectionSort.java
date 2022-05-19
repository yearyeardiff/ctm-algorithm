/**
 * $Id: SimpleSelectionSort.java,v 1.0 2018/2/1 20:00 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.选择排序;

/**
 * $Id: SimpleSelectionSort.java,v 1.0 2018/2/1 20:00 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
public class SimpleSelectionSort {
    public static void SimpleSelection_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 111, 33, 55, 6};
        SimpleSelection_sort(arr);
    }
}
