package org.zch.algorithm.graph.拓扑排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs
 */
public class 课程表2_210 {

    // 记录后序遍历结果
    List<Integer> postorder = new ArrayList<>();
    // 记录是否存在环
    boolean hasCycle = false;
    boolean[] visited, onPath;

    /**
     * dfs
     * https://mp.weixin.qq.com/s/xHmzLa4LtxOHEro0g3rBZw
     * 拓扑排序的结果就是反转之后的后序遍历结果
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle) {
            return new int[0];
        }

        Collections.reverse(postorder);
        int[] res = new int[postorder.size()];
        for (int i = 0; i < postorder.size(); i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int idx) {
        if (onPath[idx]) {
            hasCycle = true;
        }

        if (hasCycle || visited[idx]) {
            return;
        }

        visited[idx] = true;
        onPath[idx] = true;

        for (int v : graph[idx]) {
            traverse(graph, v);

        }
        postorder.add(idx);
        onPath[idx] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int [] site : prerequisites) {
            graph[site[1]].add(site[0]);
        }
        return graph;
    }

}
