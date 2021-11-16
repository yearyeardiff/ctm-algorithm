/**
 * $Id: InsertionSelect.java,v 1.0 2018/2/2 10:40 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.≤Â»Î≈≈–Ú;

/**
 * $Id: InsertionSelect.java,v 1.0 2018/2/2 10:40 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
public class InsertionSort {
    public static void insertion_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertNum = arr[i];
            int j = i;
            while (j > 0 && insertNum < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = insertNum;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 111, 33, 55, 6};
        insertion_sort(arr);
    }
}
