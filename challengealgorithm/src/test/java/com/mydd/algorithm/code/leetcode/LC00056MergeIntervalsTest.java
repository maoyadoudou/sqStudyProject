package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00056MergeIntervalsTest {

    @Test
    void merge() {
        assertArrayEquals(new int[][]{{0,4}}, new LC00056MergeIntervals().merge(new int[][]{{1, 4}, {0,4}}));
        assertArrayEquals(new int[][]{{1,5}}, new LC00056MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}}));
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, new LC00056MergeIntervals().merge(new int[][]{{1, 4}, {2, 6}, {8, 10}, {15, 18}}));
        assertArrayEquals(new int[][]{{1, 18}, {20, 25}}, new LC00056MergeIntervals().merge(new int[][]{{1, 3}, {5, 6}, {1, 18}, {20, 25}, {11, 13}, {15, 18}}));
    }
}