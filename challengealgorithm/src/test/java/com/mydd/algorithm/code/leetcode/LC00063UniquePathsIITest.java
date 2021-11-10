package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00063UniquePathsIITest {

    @Test
    void uniquePathsWithObstacles() {
        assertEquals(2, new LC00063UniquePathsII().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}