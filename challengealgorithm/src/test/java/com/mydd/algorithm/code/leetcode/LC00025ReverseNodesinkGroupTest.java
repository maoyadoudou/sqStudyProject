package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;
import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00025ReverseNodesinkGroupTest {

    @Test
    void reverseKGroup() {
        assertEquals(utg(new int[]{2,1,4,3,5}), new LC00025ReverseNodesinkGroup().reverseKGroup(utg(new int[]{1,2,3,4,5}), 2));
        assertEquals(utg(new int[]{3,2,1,4,5}), new LC00025ReverseNodesinkGroup().reverseKGroup(utg(new int[]{1,2,3,4,5}), 3));
        assertEquals(utg(new int[]{1,2,3,4,5}), new LC00025ReverseNodesinkGroup().reverseKGroup(utg(new int[]{1,2,3,4,5}), 1));
        assertEquals(utg(new int[]{3,2,1,6,5,4}), new LC00025ReverseNodesinkGroup().reverseKGroup(utg(new int[]{1,2,3,4,5,6}), 3));
        assertEquals(utg(new int[]{6,5,4,3,2,1}), new LC00025ReverseNodesinkGroup().reverseKGroup(utg(new int[]{1,2,3,4,5,6}), 6));
        assertEquals(utg(new int[]{4,3,2,1}), new LC00025ReverseNodesinkGroup().reverseKGroup(utg(new int[]{1,2,3,4}), 4));
    }

    private ListNode utg(int[] a) {
        return UnitTestUtils.generateListNode(a);
    }
}