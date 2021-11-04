package com.mydd.algorithm.code.leetcode;

import com.mydd.model.ListNode;
import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00021MergeTwoSortedListsTest {

    @Test
    void mergeTwoLists() {
        assertEquals(utg(new int[]{1,1,2,3,4,4}), new LC00021MergeTwoSortedLists().mergeTwoLists(utg(new int[]{1,2,4}), utg(new int[]{1,3,4})));
    }

    private ListNode utg(int[] a) {
        return UnitTestUtils.generateListNode(a);
    }
}