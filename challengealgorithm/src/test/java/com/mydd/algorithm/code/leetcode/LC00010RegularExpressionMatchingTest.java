package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00010RegularExpressionMatchingTest {

    @Test
    void isMatch() {
        assertEquals(true, new LC00010RegularExpressionMatching().isMatch("aaaaaabbb", "aaaaaabbb"));
        assertEquals(true, new LC00010RegularExpressionMatching().isMatch("aaaaaabbb", "a*bbb"));
        assertEquals(true, new LC00010RegularExpressionMatching().isMatch("aaaaaabbb", "a*bb*"));
    }

    @Test
    void isMatchDP() {
        assertEquals(true, new LC00010RegularExpressionMatching().isMatchDP("mississippi", "mis*is*p*."));
        assertEquals(true, new LC00010RegularExpressionMatching().isMatchDP("aaaaaabbb", "a*bbb"));
        assertEquals(true, new LC00010RegularExpressionMatching().isMatchDP("aaaaaabbb", "a*bb*"));
    }

    @Test
    void isMatch1() throws Exception {
        assertEquals(true, new LC00010RegularExpressionMatching().isMatch1("aaaaaabbb", "aaaaaabbb"));
        assertEquals(true, new LC00010RegularExpressionMatching().isMatch1("aaaaaabbb", "a*bbb"));
        assertEquals(true, new LC00010RegularExpressionMatching().isMatch1("aaaaaabbb", "a*bb*"));
    }

    @Test
    void trimStr() {
    }

    @Test
    void trimStr1() {
    }

    @Test
    void findSubStr() {
    }

    @Test
    void KMP() {
    }

    @Test
    void search() {
    }
}