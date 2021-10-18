package org.zch.ds.dp.背包问题;

/**
 * 0，1背包问题
 *
 * link: https://mp.weixin.qq.com/s/xmgK7SrTnFIM3Owpk-emmg
 */
public class Bag_01背包 {

    /**
     * 有N件物品和一个容量是C的背包。每件物品有且只有一件。
     *
     * 第i件物品的体积是v[i]，价值是w[i]。
     *
     * 二维数组解法
     *
     * @param N
     * @param C
     * @param v
     * @param w
     * @return
     */
    public int maxValue(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N + 1][C + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= C; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j - v[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[N][C];
    }

    /**
     * 滚动数组解法
     * @param N
     * @param C
     * @param v
     * @param w
     * @return
     */
    public int maxValue2(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[2][C + 1];
        for (int j = 0; j <= C; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                int index = i % 2;

                // 不选该物品
                int unSelect = dp[(i - 1) % 2][j];
                // 选择该物品
                int select = dp[(i - 1) % 2][j - v[j - 1]] + w[j - 1];

                dp[i % 2][j] = Math.max(select, unSelect);

            }
        }

        return dp[N % 2][C];
    }

    /**
     * 一位数组解法
     *
     * @param N
     * @param C
     * @param v
     * @param w
     * @return
     */
    public int maxValue3(int N, int C, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            for (int j = C; j >= v[i]; j--) {
                // 不选该物品
                int n = dp[j];
                // 选择该物品
                int y = dp[j-v[i]] + w[i];
                dp[j] = Math.max(n, y);
            }
        }
        return dp[C];
    }
}
