package org.zch.algorithm.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class ListNode138 {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    /**
     * https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
     *
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);

    }

    public static void main(String[] args) {
        Node n5 = new Node(5, null, null);
        Node n4 = new Node(4, n5, null);
        Node n3 = new Node(3, n4, null);
        Node n2 = new Node(2, n3, null);
        Node n1 = new Node(1, n2, null);
        n5.random = n1;
        n4.random = n2;
        n3.random = n1;
        n2.random = n3;
        n1.random = n5;
        copyRandomList(n1);
    }

}
