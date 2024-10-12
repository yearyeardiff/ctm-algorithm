package org.zch.algorithm.linked_list.快慢指针;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author zhangchenghao
 */
public class ListNode链表的中间结点_876 {

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

    /**
     * 1. fast 正常走（fast != null && fast.next != null），如果有两个中间结点，则slow返回第二个中间结点。
     * 2. fast 少走一步（fast.next != null && fast.next.next != null），如果有两个中间结点，则slow返回第一个中间结点。
     * 如果是基数，无论 1，2中，slow都是正中间
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
