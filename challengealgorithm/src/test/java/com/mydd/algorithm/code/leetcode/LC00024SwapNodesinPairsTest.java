package com.mydd.algorithm.code.leetcode;

import org.junit.jupiter.api.Test;
import utils.UnitTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LC00024SwapNodesinPairsTest {

    @Test
    void swapPairs() {
        assertEquals(UnitTestUtils.gln(new int[]{2,1,4,3}), new LC00024SwapNodesinPairs().swapPairs(UnitTestUtils.gln(new int[]{1,2,3,4})));
        assertEquals(UnitTestUtils.gln(new int[]{2,1,4,3,5}), new LC00024SwapNodesinPairs().swapPairs(UnitTestUtils.gln(new int[]{1,2,3,4,5})));
        assertEquals(UnitTestUtils.gln(new int[]{2,1,4,3,6,5}), new LC00024SwapNodesinPairs().swapPairs(UnitTestUtils.gln(new int[]{1,2,3,4,5,6})));
        assertEquals(UnitTestUtils.gln(new int[]{1}), new LC00024SwapNodesinPairs().swapPairs(UnitTestUtils.gln(new int[]{1})));
        assertEquals(null, new LC00024SwapNodesinPairs().swapPairs(null));

    }
}