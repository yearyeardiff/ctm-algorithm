/**
 * $Id: ShellSort.java,v 1.0 2018/2/2 13:42 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.插入排序;

/**
 * $Id: ShellSort.java,v 1.0 2018/2/2 13:42 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
public class ShellSort {
    public static void shell_sort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            insertSelect(arr, i);
        }
    }

    /**
     * 间隔为increasement的插入排序
     *
     * @param arr
     * @param increment
     */
    public static void insertSelect(int[] arr, int increment) {
        for (int i = increment; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j >= increment; j -= increment) {
                if (arr[j - increment] > temp) {
                    arr[j] = arr[j - increment];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 111, 33, 55, 6};
        shell_sort(arr);
    }
}
