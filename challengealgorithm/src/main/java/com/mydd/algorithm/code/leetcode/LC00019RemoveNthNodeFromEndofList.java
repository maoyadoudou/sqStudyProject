package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//class ListNode extends Object {
//    int val;
//    ListNode next;
//    public ListNode() {
//    }
//    ListNode(int val) {
//        this.val = val;
//    }
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//    @Override
//    public boolean equals(Object a) {
//        if (a == null) return false;
//        ListNode next0 = this, next1 = (ListNode) a;
//        while(next0 != null && next1 != null) {
//            if(next0.val == next1.val) {
//                next0 = next0.next;
//                next1 = next1.next;
//            } else {
//                return false;
//            }
//        }
//        return next0 == null && next1 == null;
//    }
//}
public class LC00019RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return new ListNode();
        }
        ListNode node = head, prev = new ListNode();
        for(int i = 1, j = i - n; ; i++, j++) {
            if (j == 0) prev = head;
            if (j > 1) prev = prev.next;
            node = node.next;
            if(node == null) {
                if(j == 0) {
                    head = head.next;
                    break;
                } else {
                    prev.next = prev.next.next;
                    break;
                }
            }
        }
        return head;
    }
}
