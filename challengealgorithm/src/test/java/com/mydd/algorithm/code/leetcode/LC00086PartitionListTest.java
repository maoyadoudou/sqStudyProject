package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import static org.junit.jupiter.api.Assertions.*;

class LC00086PartitionListTest {

    @Test
    void partition() {
        assertEquals(UnitTestUtils.gln(new int[]{1,2,2,4,3,5}), new LC00086PartitionList().partition(UnitTestUtils.gln(new int[]{1,4,3,2,5,2}), 3));
        assertEquals(UnitTestUtils.gln(new int[]{}), new LC00086PartitionList().partition(UnitTestUtils.gln(new int[]{}), 3));
        assertEquals(UnitTestUtils.gln(new int[]{1}), new LC00086PartitionList().partition(UnitTestUtils.gln(new int[]{1}), 3));
        assertEquals(UnitTestUtils.gln(new int[]{5}), new LC00086PartitionList().partition(UnitTestUtils.gln(new int[]{5}), 3));
        assertEquals(UnitTestUtils.gln(new int[]{1,3}), new LC00086PartitionList().partition(UnitTestUtils.gln(new int[]{3,1}), 3));
    }
}