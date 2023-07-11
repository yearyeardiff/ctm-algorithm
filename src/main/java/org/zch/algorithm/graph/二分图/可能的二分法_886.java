package org.zch.algorithm.graph.二分图;

import java.util.ArrayList;
import java.util.List;

/**
 * https://mp.weixin.qq.com/s/5tMzyADbfIJAAvRfSy41Ng
 */
public class 可能的二分法_886 {

    boolean[] visited;
    boolean[] colored;
    boolean ok = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n];
        colored = new boolean[n];

        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ok;
    }

    private void traverse(List<Integer>[] graph, int v) {
        if (!ok) return;

        for (Integer w : graph[v]) {
            if (!visited[w]) {
                colored[w] = !colored[v];
                visited[w] = true;
                traverse(graph, w);
            } else {
                if (colored[w] == colored[v]) {
                    ok = false;
                    break;
                }
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1].add(dislike[1] - 1);
            graph[dislike[1] - 1].add(dislike[0] - 1);
        }
        return graph;
    }
}
