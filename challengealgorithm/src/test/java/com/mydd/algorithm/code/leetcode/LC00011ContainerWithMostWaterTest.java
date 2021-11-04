package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00011ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        assertEquals(2, new LC00011ContainerWithMostWater().maxArea(new int[]{1, 2, 1}));
        assertEquals(16, new LC00011ContainerWithMostWater().maxArea(new int[]{4,3,2,1,4}));
        assertEquals(1, new LC00011ContainerWithMostWater().maxArea(new int[]{1,1}));
        assertEquals(49, new LC00011ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}