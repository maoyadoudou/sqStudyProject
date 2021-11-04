package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LC00034FindFirstandLastPositionofElementinSortedArrayTest {

    @Test
    void searchRange() {
        assertArrayEquals(new int[]{4, 6}, new LC00034FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{1,2,3,4,5,5,5,6}, 5));
        assertArrayEquals(new int[]{-1, -1}, new LC00034FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{1,2,3,4,5,5,5,6}, 8));
        assertArrayEquals(new int[]{4, 6}, new LC00034FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{1,2,3,4,5,5,5}, 5));
        assertArrayEquals(new int[]{0, 2}, new LC00034FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{5,5,5}, 5));
        assertArrayEquals(new int[]{-1, -1}, new LC00034FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{}, 5));
    }
}