package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00028ImplementstrStrTest {

    @Test
    void strStr() {
        assertEquals(0, new LC00028ImplementstrStr().strStr("aaaaaa", "a"));
        assertEquals(1, new LC00028ImplementstrStr().strStr("baaaaaa", "a"));
    }
}