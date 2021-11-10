package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00091DecodeWaysTest {

    @Test
    void numDecodings() {
        assertEquals(2, new LC00091DecodeWays().numDecodings("12"));
        assertEquals(1, new LC00091DecodeWays().numDecodings("2101"));
    }
}