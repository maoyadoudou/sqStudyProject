package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00018FourSumTest {

    @Test
    void fourSum() {
        assertEquals(new ArrayList().add(new ArrayList(Arrays.asList(0,0,0,0))), new LC00018FourSum().fourSum(new int[]{0,0,0,0}, 0));
    }
}