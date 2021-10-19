package org.zch.algorithm.linked_list;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author zhangchenghao
 */
public class ListNode92 {

    public static class ListNode {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >=  right) {
            return head;
        }

        ListNode p = head;
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;

        ListNode leftNode = null;

        int pos = 1;
        while (p != null) {
            ListNode next = p.next;
            if (pos < left) {
                pre = pre.next;
            }

            if (pos == left) {
                leftNode = p;
            }
            if (pos > left && pos <= right) {
                p.next = pre.next;
                pre.next = p;
            }

            if (pos > right) {
                leftNode.next = p;
                break;
            }
            pos++;
            p = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reverseBetween(n1, 2, 4);
    }
}
