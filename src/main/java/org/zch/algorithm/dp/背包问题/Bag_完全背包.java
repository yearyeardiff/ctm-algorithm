package org.zch.algorithm.dp.背包问题;

/**
 * 完全背包问题
 *
 * 有N种物品和一个容量为C的背包，每种物品都有无限件。
 * 第i件物品的体积是v[i]，价值是w[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 *
 * https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247486107&idx=1&sn=e5fa523008fc5588737b7ed801caf4c3&chksm=fd9ca184caeb28926959c0987208a3932ed9c965267ed366b5b82a6fc16d42f1ff40c29db5f1&token=990510480&lang=zh_CN#rd
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485124&idx=1&sn=52068c8000b90a7a972dbd04658d79b7&scene=21#wechat_redirect
 *
 *
 */
public class Bag_完全背包 {

    public int maxValue0(int N, int C, int[] v, int[] w) {
        int[][] dp = new int[N][C + 1];

        for (int j = 0; j <= C; j++) {
            // 显然当只有一件物品的时候，在容量允许的情况下，能选多少件就选多少件
            int maxK = j / v[0];
            dp[0][j] = maxK * w[0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                int kNum = j / v[i];
                int maxVal = dp[i - 1][j];
                for (int k = 0; k <= kNum; k++) {
                    maxVal = Math.max(maxVal, dp[i - 1][j - v[i] * k] + k * w[i]);
                }
                dp[i][j] = maxVal;
            }
        }
        return dp[N - 1][C];
    }

    /**
     * 一维数组
     *
     * 01 背包依赖的是「上一行正上方的格子」和「上一行左边的格子」！！！！！！！！！！
     * 完全背包依赖的是「上一行正上方的格子」和「本行左边的格子」！！！！！！！！！！！
     *
     * @param N
     * @param C
     * @param v
     * @param w
     * @return
     */
    public int maxValue1(int N, int C, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i <= C; i++) {
            dp[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= C; j++) {
                int unSelect = dp[j];
                int select = j - v[i] > 0 ? dp[j - v[i]] + w[i] : 0;
                dp[j] = Math.max(unSelect, select);
            }
        }
        return dp[C];
    }
}
