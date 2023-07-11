package org.zch.algorithm.graph.二分图;

/**
 * https://mp.weixin.qq.com/s/5tMzyADbfIJAAvRfSy41Ng
 */
public class 判断二分图_785 {
    boolean ok = true;
    boolean[] visited;
    boolean[] colored;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        colored = new boolean[n];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                traverse(graph, i);
            }
        }
        return ok;
    }

    private void traverse(int[][] graph, int v) {
        if (!ok) return;

        for (int w : graph[v]) {
            if (!visited[w]) {
                colored[w] = !colored[v];
                visited[w] = true;
                traverse(graph, w);
            } else {
                if (colored[w] == colored[v]) {
                    ok = false;
                }
            }
        }
    }

}
