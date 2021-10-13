package org.zch.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp120 {

    // ---------------------递归+备忘录-----------------------------------------------------------------------------------------------------------
    public int minimumTotal0(List<List<Integer>> triangle) {
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        return dfs(triangle, 0, 0, memo);
    }

    public int dfs(List<List<Integer>> triangle, int i, int j, Integer[][] memo) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int val = triangle.get(i).get(j);

        return memo[i][j] = Math.min(dfs(triangle, i + 1, j, memo), dfs(triangle, i + 1, j + 1, memo)) + val;
    }


    // ----------------------动态规划----------------------------------------------------------------------------------------------------------
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curVal = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + curVal;
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + curVal;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + curVal;
                }
            }
        }

        int minVal = dp[triangle.size() - 1][0];
        for (int i = 1; i < triangle.get(triangle.size() - 1).size(); i++) {
            minVal = Math.min(minVal, dp[triangle.size() - 1][i]);
        }
        return minVal;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal1(triangle));
    }




}
