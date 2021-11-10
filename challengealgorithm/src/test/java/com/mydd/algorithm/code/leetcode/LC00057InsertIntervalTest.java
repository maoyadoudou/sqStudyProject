package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00057InsertIntervalTest {

    @Test
    void insert() {
        assertArrayEquals(new int[][]{{1,3}, {5,8}, {9,13}, {21,31}}, new LC00057InsertInterval().insert(new int[][]{{1,3}, {5,7}, {9,13}, {21,31}}, new int[]{7, 8} ));
        assertArrayEquals(new int[][]{{1,3}, {5,13}, {21,31}}, new LC00057InsertInterval().insert(new int[][]{{1,3}, {5,7}, {9,13}, {21,31}}, new int[]{7, 9} ));
        assertArrayEquals(new int[][]{{1,3}, {5,7}, {9,13}, {21,31}, {37, 39}}, new LC00057InsertInterval().insert(new int[][]{{1,3}, {5,7}, {9,13}, {21,31}}, new int[]{37, 39} ));
        assertArrayEquals(new int[][]{{1,3}, {5,7}, {9,13}, {21,31}}, new LC00057InsertInterval().insert(new int[][]{{5,7}, {9,13}, {21,31}}, new int[]{1,3} ));
        assertArrayEquals(new int[][]{{1,3}}, new LC00057InsertInterval().insert(new int[][]{}, new int[]{1,3} ));
    }
}