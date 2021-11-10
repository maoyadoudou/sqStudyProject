package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LC00089GrayCodeTest {

    @Test
    void grayCode() {

        assertEquals(Arrays.asList(0,1,3,2), new LC00089GrayCode().grayCode(2));
    }
}