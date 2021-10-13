package org.zch.ds.dp;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dp最小路径和 {

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int curVal = grid[i][j];
                if (j == 0) {
                    dp[i][0] = curVal + dp[i - 1][0];
                } else {
                    dp[i][j] = curVal + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        }));
    }

}
