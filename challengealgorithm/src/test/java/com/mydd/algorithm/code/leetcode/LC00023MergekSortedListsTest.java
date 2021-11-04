package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00023MergekSortedListsTest {

    @Test
    void mergeKLists() {
        ListNode[] list = new ListNode[]{
                generate(new int[]{1, 4, 5}), generate(new int[]{1, 3, 4}), generate(new int[]{2, 6})
        };
        assertEquals(generate(new int[]{1, 1, 2, 3, 4, 4, 5, 6}),new LC00023MergekSortedLists().mergeKLists(list));
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