package org.zch.algorithm.dp.背包问题;

import java.util.Arrays;

/**
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 *
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 *
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 *
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp数位成本和为目标值的最大数字_1449 {

    /**
     * 完全背包
     *
     * @param cost
     * @param target
     * @return
     */
    public static String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= 9; i++) {
            int currentCost = cost[i - 1];
            for (int j = currentCost; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - currentCost] + 1);
            }
        }

        if (dp[target] <= 0) {
            return "0";
        }

        System.out.println(Arrays.toString(dp));

        String ans = "";
        for (int i = 9, j = target; i >= 1; i--) {
            int currentCost = cost[i - 1];
            while (j >= currentCost && dp[j] == dp[j - currentCost] + 1) {
                ans += i;
                j -= currentCost;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String result = largestNumber(new int[]{4,3,2,5,6,7,2,5,5}, 9);
    }
}
