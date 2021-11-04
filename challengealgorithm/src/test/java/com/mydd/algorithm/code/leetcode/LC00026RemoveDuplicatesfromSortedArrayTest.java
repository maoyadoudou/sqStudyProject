package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00026RemoveDuplicatesfromSortedArrayTest {

    @Test
    void removeDuplicates() {
        assertEquals(2, new LC00026RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{1,1,2}));
        assertEquals(5, new LC00026RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}