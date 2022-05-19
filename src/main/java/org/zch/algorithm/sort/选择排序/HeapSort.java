/**
 * $Id: HeapSort.java,v 1.0 2018/2/13 11:40 ZCH Exp $
 * <p>
 * Copyright 2016 Asiainfo Technologies(China),Inc. All rights reserved.
 */
package org.zch.algorithm.sort.选择排序;

public class HeapSort {

    public int[] data = new int[9999];//从0开始存储 child= parent*2 + 1
    public int size;

    public HeapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        this.size = data.length;
    }

    /**
     * 调整成最大堆
     * 从index开始到length-1结束
     *
     * @param index
     */
    public void percDown(int index, int length) {
        int parent = index;
        int tempData = data[index];

        while (parent * 2 + 1 < length) {
            int child = parent * 2 + 1;
            if (child + 1 < length && data[child + 1] > data[child]) {
                child++;
            }
            if (tempData > data[child]) {
                break;
            }
            data[parent] = data[child];
            parent = child;
        }
        data[parent] = tempData;
    }

    public void buildHeap() {
        for (int i = this.size / 2; i >= 0; i--) {
            this.percDown(i, this.size);
        }
    }


    public void heap_sort() {
        this.buildHeap();

        for (int i = size - 1; i > 0; i--) {
            // swap
            int temp = this.data[0];
            this.data[0] = this.data[i];
            this.data[i] = temp;

            // percolate down
            this.percDown(0, i);
        }
    }

    public static void main(String[] args) {
        int[] data = {66, 2, 13, 4, 5, 88, 92, 12};
        HeapSort heapSort = new HeapSort(data);
        heapSort.heap_sort();
    }

}
