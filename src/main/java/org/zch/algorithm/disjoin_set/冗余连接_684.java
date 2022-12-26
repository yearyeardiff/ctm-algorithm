package org.zch.algorithm.disjoin_set;

/**
 * 树可以看成是一个连通且 无环 的 无向 图。
 *
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 冗余连接_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weights[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];

            int node1 = edge[0] - 1;
            int node2 = edge[1] - 1;
            if (!connected(node1, node2, parent)) {
                union(node1, node2, parent, weights);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int p, int q, int[] parent, int[] weights) {
        int rootP = findRoot(p, parent);
        int rootQ = findRoot(q, parent);

        if (weights[rootP] < weights[rootQ]) {
            parent[rootP] = rootQ;
            weights[rootQ] += weights[rootP];
        } else {
            parent[rootQ] = rootP;
            weights[rootP] += weights[rootQ];
        }
    }

    private int findRoot(int p, int[] parent) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean connected(int p, int q, int[] parent) {
        int rootP = findRoot(p, parent);
        int rootQ = findRoot(q, parent);
        return rootP == rootQ;
    }

    public static void main(String[] args) {
        冗余连接_684 test = new 冗余连接_684();
        test.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});
    }
}
