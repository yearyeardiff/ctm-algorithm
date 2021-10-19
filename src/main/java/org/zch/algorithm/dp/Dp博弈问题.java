package org.zch.algorithm.dp;

import java.util.Arrays;

/**
 *
 * https://mp.weixin.qq.com/s/_d1Y7g1jnj7VFSxbo9YWSw
 */
public class Dp博弈问题 {
    /**
     * 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
     * 你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。
     * 所有石头被拿完后，谁拥有的石头多，谁获胜。
     *
     * @param piles
     * @return
     */
    public static int stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];

        // init
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair();
                dp[i][j].fir = 0;
                dp[i][j].sec = 0;
            }
        }

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int l = j;
                int r = j + i;

                int selectLeft = piles[l] + dp[l + 1][r].sec;
                int selectRight = piles[r] + dp[l][r - 1].sec;

                if (selectLeft > selectRight) {
                    dp[l][r].fir = selectLeft;
                    dp[l][r].sec = dp[l + 1][r].fir;
                } else {
                    dp[l][r].fir = selectRight;
                    dp[l][r].sec = dp[l][r - 1].fir;
                }
            }

            System.out.println(Arrays.deepToString(dp));
        }
        return dp[0][n - 1].fir - dp[0][n - 1].sec;
    }


    public static class Pair {
        public int fir;
        public int sec;

        @Override
        public String toString() {
            return "fir:" + fir + ",sec:" + sec;
        }
    }

    public static void main(String[] args) {
        stoneGame(new int[]{3, 9, 1, 2});
    }

}
