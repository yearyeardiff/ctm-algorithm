package org.zch.algorithm.graph.BFS;

import java.util.*;

/**
 * 链接：https://leetcode.cn/problems/open-the-lock
 */
public class 解开密码锁的最小次数_752 {
/**
    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (q not empty) {
            int sz = q.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                // 划重点：这里判断是否到达终点
                if (cur is target)
                return step;
                // 将 cur 的相邻节点加入队列
                for (Node x : cur.adj())
                    if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
            }
            // 划重点：更新步数在这里
            step++;
        }
    }
**/

    /**
     * 优化方法：双写BFS
     * https://mp.weixin.qq.com/s/WH_XGm1-w5882PnenymZ7g
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));

        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (deadSet.contains(cur)) {
                    continue;
                }

                if (target.equals(cur)) {
                    return depth;
                }

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (visited.add(up)) {
                        queue.offer(up);
                    }
                    String down = minusOne(cur, j);
                    if (visited.add(down)) {
                        queue.offer(down);
                    }
                }
            }
            depth++;
        }

        return -1;
    }

    private String minusOne(String cur, int i) {
        char[] ch = cur.toCharArray();
        if (ch[i] >= '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }
        return new String(ch);
    }

    private String plusOne(String cur, int i) {
        char[] ch = cur.toCharArray();
        if (ch[i] == '0')
            ch[i] = '9';
        else
            ch[i] -= 1;
        return new String(ch);
    }


}
