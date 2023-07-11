package org.zch.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 克隆图_133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // map解决循环引用
    Map<Integer, Node> map = new HashMap<>(400);
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node cur = new Node(node.val);
        map.put(node.val, cur);
        if (node.neighbors == null) {
            cur.neighbors = null;
        } else {
            cur.neighbors = new ArrayList<>();
            for (Node adj : node.neighbors) {
                Node tmp = dfs(adj);
                cur.neighbors.add(tmp);
            }
        }
        return cur;
    }
}
