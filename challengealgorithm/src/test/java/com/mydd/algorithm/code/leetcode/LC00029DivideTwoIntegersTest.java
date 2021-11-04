package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00029DivideTwoIntegersTest {

    @Test
    void divide() {
        assertEquals(2, new LC00029DivideTwoIntegers().divide(71, 35));
        assertEquals(1, new LC00029DivideTwoIntegers().divide(71, 36));
        assertEquals(1, new LC00029DivideTwoIntegers().divide(71, 71));
        assertEquals(0, new LC00029DivideTwoIntegers().divide(71, 72));
        assertEquals(-2, new LC00029DivideTwoIntegers().divide(71, -35));
        assertEquals(-1, new LC00029DivideTwoIntegers().divide(71, -36));
        assertEquals(-1, new LC00029DivideTwoIntegers().divide(71, -71));
        assertEquals(0, new LC00029DivideTwoIntegers().divide(71, -72));
        assertEquals(Integer.MAX_VALUE, new LC00029DivideTwoIntegers().divide(Integer.MIN_VALUE, -1));
        assertEquals(Integer.MAX_VALUE, new LC00029DivideTwoIntegers().divide(Integer.MAX_VALUE, 1));
        assertEquals(1, new LC00029DivideTwoIntegers().divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(-1, new LC00029DivideTwoIntegers().divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
        int a = Integer.MIN_VALUE + 1;
        assertEquals(-1, new LC00029DivideTwoIntegers().divide(a, Integer.MAX_VALUE));
        assertEquals(-1, new LC00029DivideTwoIntegers().divide(a, Integer.MAX_VALUE));
    }

    @Test
    void divide1() {
        int a = Integer.MIN_VALUE - 8;
        int b = Integer.MIN_VALUE - 1;
        assertEquals(1, new LC00029DivideTwoIntegers().divide1(a, b));
    }
}