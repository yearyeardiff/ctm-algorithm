package org.zch.algorithm.linked_list;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author zhangchenghao
 */
public class ListNode876 {

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

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        return low;
    }
}
