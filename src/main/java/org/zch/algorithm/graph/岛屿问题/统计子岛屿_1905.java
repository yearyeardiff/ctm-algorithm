package org.zch.algorithm.graph.岛屿问题;

/**
 * https://mp.weixin.qq.com/s/IZQkb-M27dt-AZ1VICThOw
 */
public class 统计子岛屿_1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    cnt++;
                    dfs(grid2, i, j);
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length) {
            return;
        }
        if (grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        dfs(grid2, i + 1, j);
        dfs(grid2, i - 1, j);
        dfs(grid2, i, j + 1);
        dfs(grid2, i, j - 1);
    }
}
