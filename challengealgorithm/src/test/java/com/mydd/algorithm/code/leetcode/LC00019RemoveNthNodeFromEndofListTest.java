package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00019RemoveNthNodeFromEndofListTest {

    @Test
    void removeNthFromEnd() {
        assertEquals(generate(new int[]{1,2,3,4}), new LC00019RemoveNthNodeFromEndofList().removeNthFromEnd(generate(new int[]{1,2,3,4,5}), 1));
        assertEquals(generate(new int[]{2,3,4,5}), new LC00019RemoveNthNodeFromEndofList().removeNthFromEnd(generate(new int[]{1,2,3,4,5}), 5));
        assertEquals(generate(new int[]{}), new LC00019RemoveNthNodeFromEndofList().removeNthFromEnd(generate(new int[]{1}), 1));
        assertEquals(generate(new int[]{1}), new LC00019RemoveNthNodeFromEndofList().removeNthFromEnd(generate(new int[]{1,2}), 1));
        assertEquals(generate(new int[]{2}), new LC00019RemoveNthNodeFromEndofList().removeNthFromEnd(generate(new int[]{1,2}), 2));
    }

    private ListNode generate(int[] input) {
        int len = input.length;
        if(len == 0) return new ListNode();
        ListNode head = new ListNode(input[0]);
        ListNode prev = head;
        for(int i = 1; i < len; i++) {
            ListNode node = new ListNode(input[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }
}