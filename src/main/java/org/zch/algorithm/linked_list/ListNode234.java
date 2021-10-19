package org.zch.algorithm.linked_list;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class ListNode234 {
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 中间节点
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }

        // 旋转右边
        ListNode q = reverseList(low.next);
        low.next = null;

        // 比对
        ListNode p = head;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }


    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;

            p.next = pre;
            pre = p;

            p = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode n2 = new ListNode(2, null);
        ListNode n1 = new ListNode(1, n2);
        isPalindrome(n1);
    }
}
