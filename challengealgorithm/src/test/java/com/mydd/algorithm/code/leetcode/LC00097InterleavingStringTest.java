package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LC00097InterleavingStringTest {

    @Test
    void isInterleave() {
        assertTrue(new LC00097InterleavingString().isInterleave("aaa", "bbb", "ababab"));
        assertTrue(new LC00097InterleavingString().isInterleave("baa", "abb", "ababab"));
        assertTrue(new LC00097InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(new LC00097InterleavingString().isInterleave("aabd", "abdc", "aabdbadc"));
    }
}