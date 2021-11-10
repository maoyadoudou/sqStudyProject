package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;

public class LC00061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        // Get head length;
        int len = 1;
        ListNode tmpNode = head;
        while(tmpNode.next != null) {
            tmpNode = tmpNode.next;
            len++;
        }
        // After loop, tmpNode is the last ListNode, which tmpNode.next == null
        // Ignore repeat whole loops;
        k = k % len;
        if (k == 0) return head;
        // If part element rotate, make last node point to head
        tmpNode.next = head;
        // Find new last ListNode
        for (int i = 0; i < (len - k); i++) {
            tmpNode = tmpNode.next;
        }
        head = tmpNode.next;
        tmpNode.next = null;
        return head;
    }
}
