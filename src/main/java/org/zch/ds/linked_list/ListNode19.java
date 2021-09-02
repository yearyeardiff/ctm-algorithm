package org.zch.ds.linked_list;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class ListNode19 {
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

    /**
     * 双指针
     * 快指针先走n步，然后和慢指针一起走
     *
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1, head);
        ListNode fast = newHead;
        ListNode slow = newHead;

        while (n >= 0) {
            fast = fast.next;
            n --;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode tmp = slow.next;
        slow.next = tmp.next;
        tmp.next = null;

        return newHead.next;
    }
}
