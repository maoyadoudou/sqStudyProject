package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00035SearchInsertPositionTest {

    @Test
    void searchInsert() {
        assertEquals(4, new LC00035SearchInsertPosition().searchInsert(new int[]{1,2,3,4,5,6}, 5));
        assertEquals(6, new LC00035SearchInsertPosition().searchInsert(new int[]{1,2,3,4,5,6}, 8));
        assertEquals(4, new LC00035SearchInsertPosition().searchInsert(new int[]{1,2,3,4}, 5));
        assertEquals(0, new LC00035SearchInsertPosition().searchInsert(new int[]{5}, 5));
    }
}