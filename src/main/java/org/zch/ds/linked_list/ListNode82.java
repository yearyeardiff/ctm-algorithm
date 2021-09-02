package org.zch.ds.linked_list;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author zhangchenghao
 */
public class ListNode82 {
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmpHead = new ListNode(-1, head);
        ListNode p = tmpHead;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int duplicateVal = p.next.val;
                while (p.next != null && p.next.val == duplicateVal) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return tmpHead.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(3, null);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(2, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        deleteDuplicates(n1);
    }


}
