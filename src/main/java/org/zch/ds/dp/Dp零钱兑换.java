package org.zch.ds.dp;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int unSelect = dp[j];
                int select = j >= coins[i] ? dp[j - coins[i]] + 1 : max;
                dp[j] = Math.min(unSelect, select);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    //---------------备忘录+回溯-----------------------------
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int remain, int[] memo) {
        if (remain < 0) {
            return -1;
        }
        if (remain == 0) {
            return 0;
        }

        if (memo[remain - 1] != 0) {
            return memo[remain - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = coinChange(coins, remain - coin, memo);
            if (num >= 0 && num < min) {
                min = num + 1;
            }
        }
        memo[remain - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return memo[remain - 1];
    }
}
