package org.zch.algorithm.dp.字符串问题;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Dp最大子数组和_53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        System.arraycopy(nums, 0, dp, 0, nums.length);

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
