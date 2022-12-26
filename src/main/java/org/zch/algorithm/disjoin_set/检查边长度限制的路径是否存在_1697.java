package org.zch.algorithm.disjoin_set;

import java.util.Arrays;

/**
 *
 */
public class 检查边长度限制的路径是否存在_1697 {

    /**
     * https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/solution/by-sen-xm-u2xn/
     *
     * @param n
     * @param edgeList
     * @param queries
     * @return
     */
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // 边按照长度排序
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        // query按照长度排序,
        // 但是不能直接对query排序，因为result要根据原query的顺序展示结果
        // 用index代替query来排序，index的值就是query下标
        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> queries[a][2] - queries[b][2]);

        // 并查集
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        // 依次遍历 queries：如果 k 指向的边的长度小于对应查询的 limit，则将该边加入并查集中，然后将 k 加 1，直到 k 指向的边不满足要求；
        // 最后根据并查集查询对应的 p 和 q 是否属于同一集合来保存查询的结果。
        boolean[] result = new boolean[queries.length];
        int k = 0;
        for (int idx : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[idx][2]) {
                union(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            result[idx] = connected(uf, queries[idx][0], queries[idx][1]);
        }
        return result;
    }

    private boolean connected(int[] uf, int p, int q) {
        int parentP =  find(uf, p);
        int parentQ = find(uf, q);
        return parentP == parentQ;
    }

    private int find(int[] uf, int q) {
        while (uf[q] != q) {
            uf[q] = uf[uf[q]];
            q = uf[q];
        }
        return q;
    }

    private void union(int[] uf, int p, int q) {
        int parentP =  find(uf, p);
        int parentQ = find(uf, q);
        if (parentP == parentQ) {
            return;
        }
        uf[parentP] = parentQ;
    }

    public static void main(String[] args) {
        检查边长度限制的路径是否存在_1697 test = new 检查边长度限制的路径是否存在_1697();
        test.distanceLimitedPathsExist(3,
                new int[][] {
                        {0,1,2},{1,2,4},{2,0,8},{1,0,16}
                },
                new int[][]{
                        {0,1,2},{0,2,5}
                });
    }
}
