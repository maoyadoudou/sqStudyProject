package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;

public class LC00086PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode iterator = head, xlHead = null, xlTail = null, xrHead = null, xrTail = null;
        boolean initStage = true;
        while (iterator != null) {
            if (initStage) {
                if (iterator.val < x) {
                    if (xlHead == null) {
                        xlHead = iterator;
                    }
                    xlTail = iterator;
                } else {
                    if (xrHead == null) {
                        xrHead = iterator;
                    }
                    xrTail = iterator;
                }
                initStage = xlHead == null || xrHead == null;
                if (!initStage) {
                    if (head.val >= x) {
                        xrTail.next = xlTail.next;
                        xlTail.next = xrHead;
                        head = xlHead;
                    }
                    iterator = xrTail.next;
                } else {
                    iterator = iterator.next;
                }
            } else {
                if (iterator.val < x) {
                    xrTail.next = iterator.next;
                    iterator.next = xrHead;
                    xlTail.next = iterator;
                    xlTail = iterator;
                } else {
                    xrTail = iterator;
                }
                iterator = xrTail.next;
            }
        }
        return head;
    }
}
