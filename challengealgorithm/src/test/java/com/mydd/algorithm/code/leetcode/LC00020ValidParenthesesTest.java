package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00020ValidParenthesesTest {

    @Test
    void isValid() {
        assertEquals(true, new LC00020ValidParentheses().isValid("{{{}}}[[[[]]]]()"));
        assertEquals(false, new LC00020ValidParentheses().isValid("{{{}}}[[[[]]]]("));
    }
}