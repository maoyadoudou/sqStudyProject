package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;

public class LC00025ReverseNodesinkGroup {
    ListNode left, right;
    public ListNode reverseKGroup(ListNode head, int k) {
        right = head;
        int len = 0;
        do {
            right = right.next;
            len++;
        } while(right != null);
        len -= k;
        if(len < 0 || k == 1) return head;

        int i = k - 1;
        right = head;
        do{
            right = right.next;
        } while (--i > 0);
        left = head;
        swap(left, right, left.next, k);
        head = right;

        ListNode prev = left;
        len -= k;
        while (0 <= len) {
            move(right, left, k);
            swap1(left, right, prev, k);
            prev = left;
            len -= k;
        }
        return head;
    }

    private void move(ListNode l, ListNode r, int k) {
        int i = k;
        right = r;
        left = l;
        do{
            right = right.next;
            left = left.next;
        } while(--i > 0);
    }

    private void swap(ListNode a, ListNode b, ListNode prev, int k){
        if(k == 2) {
            a.next = b.next;
            b.next = a;
            return;
        } else {
            a.next = b.next;
            b.next = prev;
        }

        int i = k - 3;
        while(i-- > 0) prev = prev.next;
        prev.next = a;
        if(k > 3) swap1(b.next, prev, b, k - 2);
    }

    private void swap1(ListNode a, ListNode b, ListNode prev, int k){
        prev.next = b;

        if(k == 2) {
            a.next = b.next;
            b.next = a;
            return;
        } else {
            prev = a.next;
            a.next = b.next;
            b.next = prev;
        }

        int i = k - 3;
        while(i-- > 0) prev = prev.next;
        prev.next = a;
        if(k > 3) swap1(b.next, prev, b, k - 2);
    }
}
