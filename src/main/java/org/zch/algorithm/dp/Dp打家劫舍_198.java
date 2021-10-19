package org.zch.algorithm.dp;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp打家劫舍_198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int select = i - 2 >= 0 ? dp[i - 2] + nums[i] : nums[i];
            int unSelect = dp[i - 1];
            dp[i] = Math.max(select, unSelect);
        }

        return dp[nums.length - 1];
    }
}
