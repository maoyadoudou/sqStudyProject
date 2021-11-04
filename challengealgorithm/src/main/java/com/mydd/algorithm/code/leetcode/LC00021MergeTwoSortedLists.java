package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;

public class LC00021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode next, smaller, tmp;
        if (l1.val > l2.val) {
            next = l1;
            smaller = l2;
        } else {
            next = l2;
            smaller = l1;
        }
        while(smaller.next != null) {
            if (smaller.next.val < next.val) {
                smaller = smaller.next;
            } else {
                tmp = next;
                next = smaller.next;
                smaller.next = tmp;
                smaller = smaller.next;
            }
        }
        smaller.next = next;
        return l1.val > l2.val ? l2 : l1;
    }
}
