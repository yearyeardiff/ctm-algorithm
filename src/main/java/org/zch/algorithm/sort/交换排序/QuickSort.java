/**
 * $Id: QuickSort.java,v 1.0 2018/2/2 14:04 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.交换排序;

/**
 * $Id: QuickSort.java,v 1.0 2018/2/2 14:04 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
public class QuickSort {
    public static void quick_sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotNum = arr[left];
        while (left < right) {
            while (left < right && arr[right] > pivotNum) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < pivotNum) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = pivotNum;
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 111, 33, 55, 6};
        quick_sort(arr);
    }
}
