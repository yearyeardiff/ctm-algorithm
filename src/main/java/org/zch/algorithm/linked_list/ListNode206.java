package org.zch.algorithm.linked_list;

/**
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author zhangchenghao
 */
public class ListNode206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1, null);
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = q;
        }
        return newHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = newHead;
            newHead = p;
            p = q;
        }
        return newHead;
    }
}
