package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00041FirstMissingPositiveTest {

    @Test
    void firstMissingPositive() {
        assertEquals(2, new LC00041FirstMissingPositive().firstMissingPositive(new int[]{0,0,1,1,4,5,-2}));
        assertEquals(1, new LC00041FirstMissingPositive().firstMissingPositive(new int[]{-2,-4,-2}));
        assertEquals(4, new LC00041FirstMissingPositive().firstMissingPositive(new int[]{-2,-4,-2, 1,2,3,5,6}));
        assertEquals(1, new LC00041FirstMissingPositive().firstMissingPositive(new int[]{-2,-4,-2,5,6}));
        assertEquals(1, new LC00041FirstMissingPositive().firstMissingPositive(new int[]{5,6}));
        assertEquals(7, new LC00041FirstMissingPositive().firstMissingPositive(new int[]{0,1,2,3,4,4,5,5,6}));
    }
}