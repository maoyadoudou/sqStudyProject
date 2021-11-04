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
public class LC00023MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length, end = len, i;
        if (len == 0) return new ListNode();
        len--;
        while(len > 0) {
            for(i = 0; 2 * i < len; i++) {
                lists[i] = compareMergeListNode(lists[i], lists[len - i]);
                lists[len - i] = null;
            }
            len = len % 2 == 0 ? i : i - 1;
        }
        return lists[0];
    }

    private ListNode compareMergeListNode(ListNode node1, ListNode node2) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        ListNode iterNode, head, next1 = node1, next2 = node2;
        boolean gt = next1.val > next2.val;
        iterNode = gt ? next2 : next1;
        head = iterNode;
        while(true) {
            if(gt) {
                next2 = next2.next;
                if (next2 == null) break;
                if (next1.val <= next2.val) {
                    gt = false;
                    iterNode.next = next1;
                    iterNode = next1;
                } else {
                    iterNode = next2;
                }
            } else {
                next1 = next1.next;
                if (next1 == null) break;
                if (next1.val > next2.val) {
                    gt = true;
                    iterNode.next = next2;
                    iterNode = next2;
                } else {
                    iterNode = next1;
                }
            }
        }
        iterNode.next = gt ? next1 : next2;
        return head;
    }
}
