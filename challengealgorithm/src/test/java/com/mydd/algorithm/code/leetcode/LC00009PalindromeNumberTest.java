package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00009PalindromeNumberTest {

    @Test
    void isPalindrome() {
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome(121));
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome(112211));
        assertEquals(false, new LC00009PalindromeNumber().isPalindrome(-1121));
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome(0));
        assertEquals(false, new LC00009PalindromeNumber().isPalindrome(10));
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome(1001));
    }

    @Test
    void isPalindrome2() {
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome2(121));
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome2(112211));
        assertEquals(false, new LC00009PalindromeNumber().isPalindrome2(-1121));
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome2(0));
        assertEquals(false, new LC00009PalindromeNumber().isPalindrome2(10));
        assertEquals(true, new LC00009PalindromeNumber().isPalindrome2(1001));
    }
}