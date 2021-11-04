package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00032LongestValidParenthesesTest {

    @Test
    void longestValidParentheses() {
        assertEquals(4, new LC00032LongestValidParentheses().longestValidParentheses(")()())"));
        assertEquals(2, new LC00032LongestValidParentheses().longestValidParentheses("()(()"));

    }
}