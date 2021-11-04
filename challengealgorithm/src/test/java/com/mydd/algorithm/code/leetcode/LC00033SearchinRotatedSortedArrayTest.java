package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00033SearchinRotatedSortedArrayTest {

    @Test
    void search() {
        assertEquals(4, new LC00033SearchinRotatedSortedArray().search(new int[]{1,2,3,4,5,6}, 5));
        assertEquals(4, new LC00033SearchinRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(5, new LC00033SearchinRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 1));
        assertEquals(1, new LC00033SearchinRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 5));
        assertEquals(2, new LC00033SearchinRotatedSortedArray().search(new int[]{4,5,0,1,2}, 0));
        assertEquals(0, new LC00033SearchinRotatedSortedArray().search(new int[]{0}, 0));
        assertEquals(-1, new LC00033SearchinRotatedSortedArray().search(new int[]{0}, 1));
    }
}