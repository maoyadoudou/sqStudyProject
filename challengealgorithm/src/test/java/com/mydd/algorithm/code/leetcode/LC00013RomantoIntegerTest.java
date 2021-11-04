package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00013RomantoIntegerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void romanToInt() {
        assertEquals(3, new LC00013RomantoInteger().romanToInt("III"));
        assertEquals(4, new LC00013RomantoInteger().romanToInt("IV"));
        assertEquals(7, new LC00013RomantoInteger().romanToInt("VII"));
        assertEquals(1, new LC00013RomantoInteger().romanToInt("I"));
        assertEquals(9, new LC00013RomantoInteger().romanToInt("IX"));
        assertEquals(58, new LC00013RomantoInteger().romanToInt("LVIII"));
        assertEquals(1994, new LC00013RomantoInteger().romanToInt("MCMXCIV"));
        assertEquals(3003, new LC00013RomantoInteger().romanToInt("MMMIII"));
    }
}