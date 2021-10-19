package org.zch.algorithm.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class Sq84 {

    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {

            int widthL = 0;
            for (int j = i - 1; j >= 0; j --) {
                if (heights[j] < heights[i]) {
                    break;
                }
                widthL ++;
            }

            int widthR = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                widthR ++;
            }

            maxArea = Math.max(maxArea, heights[i] * (widthL + widthR + 1));
        }

        return maxArea;
    }

    /**
     * 单调递增 栈
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int maxArea = 0;

        // 拷贝一个新的数组，数组开始和结束 各新增一个值为0的哨兵
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[0] = 0;
        newHeight[newHeight.length - 1] = 0;

        // 单调栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < newHeight.length; i++) {
            while (newHeight[i] < newHeight[stack.peek()]) {
                int curHeight = newHeight[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, curHeight * curWidth);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        largestRectangleArea2(new int[] {2,1,2});
    }
}
