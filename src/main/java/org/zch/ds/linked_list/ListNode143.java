package org.zch.ds.linked_list;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 *
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 *  L0 → L1 → … → Ln-1 → Ln 
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ListNode143 {

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

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode low = head;

        // 中间的节点
        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        // 右边的节点反转
        ListNode rightHalfHead = null;
        ListNode pr = low.next;
        low.next = null;
        while (pr != null) {
            ListNode next = pr.next;
            pr.next = rightHalfHead;
            rightHalfHead = pr;
            pr = next;
        }

        // 合并左边的节点和右边的节点
        ListNode pl = head;
        pr = rightHalfHead;
        while (pr != null) {
            ListNode next = pr.next;

            pr.next = pl.next;
            pl.next = pr;

            pl = pl.next.next;
            pr = next;
        }
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        reorderList(n1);
    }

}
