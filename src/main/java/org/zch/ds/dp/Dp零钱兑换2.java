package org.zch.ds.dp;

/**
 *给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。 
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Dp零钱兑换2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int unSelect = dp[j];
                int select = j >= coins[i] ? dp[j - coins[i]] : 0;
                dp[j] = unSelect + select;
            }
        }

        return dp[amount];
    }
}
