package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00044WildcardMatchingTest {

    @Test
    void isMatch() {
        assertEquals(true, new LC00044WildcardMatching().isMatch("aa", "??"));
        assertEquals(false, new LC00044WildcardMatching().isMatch("", "a*bb*"));
        assertEquals(true, new LC00044WildcardMatching().isMatch("", ""));
        assertEquals(false, new LC00044WildcardMatching().isMatch("aaaaaabbb", ""));
        assertEquals(true, new LC00044WildcardMatching().isMatch("mississippi", "mis*is*p*?"));
        assertEquals(true, new LC00044WildcardMatching().isMatch("aaaaaabbb", "a*bbb"));
        assertEquals(true, new LC00044WildcardMatching().isMatch("aaaaaabbb", "a*bb*"));
    }
}