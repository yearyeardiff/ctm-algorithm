/**
 * $Id: MergeSort.java,v 1.0 2018/2/13 13:21 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort;

/**
 * $Id: MergeSort.java,v 1.0 2018/2/13 13:21 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 归并排序
 */
public class MergeSort {

    void merge_sort(int[] arr) {
        int[] tempArr = new int[arr.length];
        merge_sort(arr, tempArr, 0, arr.length - 1);
    }

    /**
     * 递归归并
     * @param arr
     * @param tempArr
     * @param left
     * @param right
     */
    void merge_sort(int[] arr, int[] tempArr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, tempArr, left, mid);
            merge_sort(arr, tempArr, mid + 1, right);
            merge(arr, tempArr, left, mid + 1, right);
        }
    }

    private void merge(int[] arr, int[] tempArr, int left, int mid, int right) {
        int leftEnd = mid - 1;
        int rightStart = mid;

        int tempLeft = left;
        int tempIndex = left;

        while (left <= leftEnd && rightStart <= right) {
            if (arr[left] <= arr[rightStart]) {
                tempArr[tempIndex++] = arr[left++];
            } else {
                tempArr[tempIndex++] = arr[rightStart++];
            }
        }

        while (left <= leftEnd) {
            tempArr[tempIndex++] = arr[left++];
        }
        while (rightStart <= right) {
            tempArr[tempIndex++] = arr[rightStart++];
        }

        for (int i = tempLeft; i < tempIndex; i++) {
            arr[i] = tempArr[i];
        }
    }

    @Test
    public void test1() {

        int[] arr = {34, 12, 66, 2, 4, 77, 8, 1};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge_sort(arr);
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd 23:59:59")));
    }
}
