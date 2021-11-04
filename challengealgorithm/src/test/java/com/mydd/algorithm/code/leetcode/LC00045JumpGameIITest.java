package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00045JumpGameIITest {

    @Test
    void jump() {
        assertEquals(2, new LC00045JumpGameII().jump(new int[]{2,3,1,1,4}));
        assertEquals(0, new LC00045JumpGameII().jump(new int[]{2}));
        assertEquals(1, new LC00045JumpGameII().jump(new int[]{2,3}));

        assertEquals(0, new LC00045JumpGameII().jump(new int[]{2,1,0,4}));
    }
}