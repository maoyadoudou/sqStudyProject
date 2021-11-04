package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00055JumpGameTest {

    @Test
    void canJump() {
        assertTrue(new LC00055JumpGame().canJump(new int[]{2,3,1,1,4}));
        assertFalse(new LC00055JumpGame().canJump(new int[]{3,2,1,0,4}));
        assertFalse(new LC00055JumpGame().canJump(new int[]{0,1,0,0,4}));
    }
}