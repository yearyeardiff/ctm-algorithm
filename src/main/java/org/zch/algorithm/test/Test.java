package org.zch.algorithm.test;

import com.sun.jmx.snmp.SnmpNull;
import org.zch.algorithm.test.Test.ListNode;

public class Test {
    public boolean field;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(-1, head), pre = newHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = left; i < right; i++) {
            ListNode next = cur.next;

            cur.next = next.next;
            next.next = cur;
            pre.next = next;
        }

        return newHead.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead, p = list1, q = list2;

        while (p != null && q != null) {
            if (p.val < q.val) {
                pre.next = p;
                p = p.next;
            } else {
                pre.next = q;
                q = q.next;
            }
            pre = pre.next;
        }

        if (p != null) pre.next = p;
        if (q != null) pre.next = q;

        return newHead.next;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode p = head, q = reverse6(slow.next);

        while (p != null && q != null) {
            ListNode pN = p.next;
            ListNode qN = q.next;

            p.next = q;
            q.next = pN;

            q = qN;
            p = pN;
        }
    }

    private ListNode reverse6(ListNode head) {
        ListNode newHead = null, p = head;
        while (p != null) {
            ListNode next = p.next;

            p.next = newHead;
            newHead = p;
            p = next;
        }

        return null;
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode l7 = new ListNode(1);
        ListNode l6 = new ListNode(2, l7);
        ListNode l5 = new ListNode(3, l6);
        ListNode l4 = new ListNode(4, l5);

        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(1, l2);

        test.isPalindrome(l1);
        System.out.printf("111");
    }


}
