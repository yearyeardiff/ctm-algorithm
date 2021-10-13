package org.zch.ds.dp;

import java.util.Arrays;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 通用解法：https://mp.weixin.qq.com/s/lQEj_K1lUY83QtIzqTikGA
 */
public class Dp买卖股票 {

    /**
     * k=1
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length][0];
    }


    /**
     * k = +infinity
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * @param prices
     * @return
     */
    public static int maxProfit_infinity(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length][0];
    }

    /**
     * k = +infinity with cooldown
     * 每次 sell 之后要等一天才能继续交易
     *
     * @return
     */
    public static int maxProfit_with_cooldown(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            } else if (i == 1) {
                dp[1][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[1][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    /**
     * k = +infinity with fee
     * 每次交易要支付手续费
     *
     * @param prices
     * @return
     */
    public static int maxProfit_with_fee(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];

        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1] - fee);
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[prices.length][0];
    }


    public static int maxProfit_with_k(int[] prices, int maxK) {
        int[][][] dp = new int[prices.length][maxK + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int j = maxK; j > 0; j--) {
                if (i == 0) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = - prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][maxK][0];
    }


    public static void main(String[] args) {
        int profit = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit);
    }
}
