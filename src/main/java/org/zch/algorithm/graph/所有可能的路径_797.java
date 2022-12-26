package org.zch.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 所有可能的路径_797 {

    /**
     * https://mp.weixin.qq.com/s/olJRzW6be6ltvWUqVBVf5Q
     */
    List<List<Integer>> pathList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0, new ArrayList<>());
        return pathList;
    }

    private void traverse(int[][] graph, int s, List<Integer> path) {
        // 添加节点 s 到路径
        path.add(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            pathList.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.remove(path.size() - 1);
    }

}
