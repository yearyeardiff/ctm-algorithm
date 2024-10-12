package org.zch.algorithm.linked_list.反转链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author zhangchenghao
 */
public class ListNode反转链表2_92 {

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
     * https://leetcode.cn/problems/reverse-linked-list-ii/solutions/634701/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }

        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead, cur, next;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        cur = pre.next;
        for (int i = left; i < right; i++) {
            next = cur.next;

            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
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
