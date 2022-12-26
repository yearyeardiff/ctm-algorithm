package org.zch.algorithm.disjoin_set;

import java.util.Arrays;

public class 寻找图中是否存在路径_1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] uf = new int[n];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }

        for (int[] edge : edges) {
            union(uf, edge[0], edge[1]);
        }

        return connected(uf, source, destination);
    }

    private boolean connected(int[] uf, int p, int q) {
        return find(uf, p) == find(uf, q);
    }

    private void union(int[] uf, int p, int q) {
        int parentP = find(uf, p);
        int parentQ = find(uf, q);

        if (parentP == parentQ) {
            return;
        }
        uf[parentP] = parentQ;
    }

    private int find(int[] uf, int p) {
        while (uf[p] != p) {
            uf[p] = uf[uf[p]];
            p = uf[p];
        }
        return p;
    }

    public int maximumScore(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);

        int sum = arr[0] + arr[1];
        if (sum <= arr[2]) {
            return sum;
        }
        return (sum - arr[2]) / 2 + arr[2];
    }

    public static void main(String[] args) {
        // 解答失败: 测试用例:10 [[0,7],[0,8],[6,1],[2,0],[0,4],[5,8],[4,7],[1,3],[3,5],[6,5]] 7 5 测试结果:false 期望结果:true stdout:
        寻找图中是否存在路径_1971 test = new 寻找图中是否存在路径_1971();
        test.validPath(10, new int[][]{
                {0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}
        }, 7, 5);
    }
}
