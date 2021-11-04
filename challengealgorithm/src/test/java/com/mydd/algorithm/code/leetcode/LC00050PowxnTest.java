package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00050PowxnTest {

    @Test
    void myPow() {
        assertEquals(4, new LC00050Powxn().myPow(2, 2));
        assertEquals(0.25, new LC00050Powxn().myPow(2, -2));
    }
}