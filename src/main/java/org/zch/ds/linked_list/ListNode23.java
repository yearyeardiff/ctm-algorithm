package org.zch.ds.linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author zhangchenghao
 */
public class ListNode23 {

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

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        } else if (begin > end) {
            return null;
        }

        int mid = (begin + end) >> 1;

        return mergeTwo(merge(lists, begin, mid), merge(lists, mid + 1, end));
    }

    public ListNode mergeTwo(ListNode l, ListNode r) {
        ListNode newHead = new ListNode(-1, null);
        ListNode p = newHead;
        while (l != null && r != null) {
            if (l.val < r.val) {
                p.next = l;
                l = l.next;
            } else {
                p.next = r;
                r = r.next;
            }
            p = p.next;
        }
        p.next = l == null ? r : l;
        return newHead.next;
    }
}
