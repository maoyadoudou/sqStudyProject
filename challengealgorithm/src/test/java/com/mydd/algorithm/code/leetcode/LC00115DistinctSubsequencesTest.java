package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00115DistinctSubsequencesTest {

    @Test
    void numDistinct() {
        assertEquals(286, new LC00115DistinctSubsequences().numDistinct("aaaaaaaaaaaaa", "aaa"));
        assertEquals(78, new LC00115DistinctSubsequences().numDistinct("aaaaaaaaaaaaa", "aa"));
        assertEquals(2, new LC00115DistinctSubsequences().numDistinct("aabb", "aab"));
        assertEquals(3, new LC00115DistinctSubsequences().numDistinct("ddd", "dd"));
        assertEquals(3, new LC00115DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
        assertEquals(0, new LC00115DistinctSubsequences().numDistinct("rabbbit", "zz"));
        assertEquals(0, new LC00115DistinctSubsequences().numDistinct("rabbbit", "rbz"));
        assertEquals(3, new LC00115DistinctSubsequences().numDistinct("rabbbit", "rbt"));
        assertEquals(6, new LC00115DistinctSubsequences().numDistinct("rabbbitt", "rbt"));
        assertEquals(6, new LC00115DistinctSubsequences().numDistinct("rabbbtt", "rbt"));
        assertEquals(8, new LC00115DistinctSubsequences().numDistinct("rabbtbtt", "rbt"));
        assertEquals(5, new LC00115DistinctSubsequences().numDistinct("babgbag", "bag"));
    }
}