package org.zch.algorithm.dp.字符串问题;

import java.util.Arrays;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 *
 *https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class Dp两个字符串的删除操作_583 {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delLeft = dp[i - 1][j] + 1;
                    int delRight = dp[i][j - 1] + 1;
                    dp[i][j] = Math.min(delLeft, delRight);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        minDistance("sea", "eat");
    }
}
