package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;

public class LC00024SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        boolean isSwap = true;
        ListNode prev = new ListNode(), left = head, right = head.next;
        left.next = right.next;
        right.next = left;
        head = right;
        right = left.next;
        while(right != null) {
            if(isSwap = !isSwap) {
                left.next = right.next;
                right.next = left;
                prev.next = right;
                right = left.next;
            } else {
                prev = left;
                left = right;
                right = right.next;
            }
        }
        return head;
    }
}
