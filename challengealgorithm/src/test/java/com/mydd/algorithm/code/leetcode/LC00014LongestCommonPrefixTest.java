package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00014LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        assertEquals("fl", new LC00014LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", new LC00014LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
        assertEquals("", new LC00014LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow",""}));
        assertEquals("", new LC00014LongestCommonPrefix().longestCommonPrefix(new String[]{"","flow","flight"}));
        assertEquals("", new LC00014LongestCommonPrefix().longestCommonPrefix(new String[]{""}));
    }
}