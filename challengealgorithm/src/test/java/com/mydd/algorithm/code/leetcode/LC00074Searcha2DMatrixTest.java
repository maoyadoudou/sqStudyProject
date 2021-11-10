package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00074Searcha2DMatrixTest {

    @Test
    void searchMatrix() {
        assertTrue(new LC00074Searcha2DMatrix().searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},3));
    }
}