package org.zch.ds.dp.背包问题;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Dp完全平方数_279 {

    /**
     * 完全背包
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int max = n + 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = max;
        }

        int maxNum = (int) Math.sqrt(n);
        for (int i = 1; i <= maxNum; i++) {
            for (int j = 1; j <= n; j++) {
                int unSelect = dp[j];
                int select = j >= i * i ? dp[j - i * i] + 1 : max;
                dp[j] = Math.min(unSelect, select);
            }
        }
        return dp[n];
    }
}
