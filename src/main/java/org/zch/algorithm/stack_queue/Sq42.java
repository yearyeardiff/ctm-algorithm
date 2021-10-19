package org.zch.algorithm.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Sq42 {

    /**
     * 动态规划
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];

        leftMaxArr[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }

        rightMaxArr[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMaxArr[j] = Math.max(height[j], rightMaxArr[j + 1]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return sum;
    }


    /**
     * 单调递减栈
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        Deque<Integer> stack = new LinkedList<>();

        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftIndex = stack.peek();
                sum += (i - leftIndex - 1) * (Math.min(height[leftIndex], height[i]) - height[curIndex]);
            }
            stack.push(i);
        }
        return sum;
    }
}
