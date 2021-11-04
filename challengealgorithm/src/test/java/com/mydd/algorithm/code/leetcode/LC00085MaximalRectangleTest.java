package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00085MaximalRectangleTest {

    @Test
    void maximalRectangle() {
        assertEquals(6, new LC00085MaximalRectangle().maximalRectangle(new char[][]{{'1', '0', '1', '1', '1'}, {'0', '1', '0', '1', '0'}, {'1', '1', '0', '1', '1'}, {'1', '1', '0', '1', '1'}, {'0', '1', '1', '1', '1'}}));
    }
}