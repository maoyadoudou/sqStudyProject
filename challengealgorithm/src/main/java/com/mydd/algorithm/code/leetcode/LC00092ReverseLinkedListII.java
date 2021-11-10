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
public class LC00092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) return head;
        ListNode rightNode = head, leftNode = head, preLeftNode = left > 1 ? head : null;
        for (int i = 1; i < right + right - left; i++) {
            if (i < right) {
                rightNode = rightNode.next;
                if (i == left - 1) leftNode = rightNode;
                if (i == left - 2) preLeftNode = rightNode;
            } else {
                if (left == 1) {
                    preLeftNode = preLeftNode == null ? leftNode.next : preLeftNode.next;
                } else {
                    preLeftNode.next = leftNode.next;
                }
                leftNode.next = rightNode.next;
                rightNode.next = leftNode;
                leftNode = left == 1 ? preLeftNode : preLeftNode.next;
            }
        }
        if (left == 1) head = preLeftNode;
        return head;
    }
}
