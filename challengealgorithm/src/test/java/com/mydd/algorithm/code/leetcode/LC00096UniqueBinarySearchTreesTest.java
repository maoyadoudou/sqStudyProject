package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00096UniqueBinarySearchTreesTest {

    @Test
    void numTrees() {

        assertEquals(42,new LC00096UniqueBinarySearchTrees().numTrees(5));
    }
}