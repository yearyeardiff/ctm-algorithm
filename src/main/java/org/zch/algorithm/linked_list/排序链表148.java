package org.zch.algorithm.linked_list;


public class 排序链表148 {

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



    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(half);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(), p1 = head1, p2 = head2, q = newHead;
        while (p1 != null && p2 != null) {

            if (p1.val < p2.val) {
                q.next = p1;
                p1 = p1.next;
            } else {
                q.next = p2;
                p2 = p2.next;
            }
            q = q.next;
        }
        q.next = p1 != null ? p1 : p2;
        return newHead.next;
    }

}
