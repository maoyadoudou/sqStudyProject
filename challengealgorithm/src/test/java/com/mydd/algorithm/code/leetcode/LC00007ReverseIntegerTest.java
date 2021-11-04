package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00007ReverseIntegerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void reverse() {
        assertEquals(-2143847412, new LC00007ReverseInteger().reverse(-2147483412));
    }
}