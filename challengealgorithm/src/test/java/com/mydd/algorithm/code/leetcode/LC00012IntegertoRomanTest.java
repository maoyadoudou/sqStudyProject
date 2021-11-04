package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00012IntegertoRomanTest {

    @Test
    void intToRoman() {
        assertEquals("III", new LC00012IntegertoRoman().intToRoman(3));
        assertEquals("IV", new LC00012IntegertoRoman().intToRoman(4));
        assertEquals("IX", new LC00012IntegertoRoman().intToRoman(9));
        assertEquals("LVIII", new LC00012IntegertoRoman().intToRoman(58));
        assertEquals("MCMXCIV", new LC00012IntegertoRoman().intToRoman(1994));
        assertEquals("MMMIII", new LC00012IntegertoRoman().intToRoman(3003));
    }
}