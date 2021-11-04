package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00042TrappingRainWaterTest {

    @Test
    void trap() {
        assertEquals(6, new LC00042TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, new LC00042TrappingRainWater().trap(new int[]{4,2,0,3,2,5}));
    }
}